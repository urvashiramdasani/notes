package DesignMultiLevelCache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

// This one solves the server crashing in between and storage and lru structures going out of sync
// 1. The Unified Node (Holds Data AND Tracking Pointers)
class CacheNode<K, V> {
    K key;
    V value;
    CacheNode<K, V> next;
    CacheNode<K, V> prev;

    public CacheNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

// 2. The Unified, Thread-Safe Cache Level
class UnifiedCacheLevel<K, V> {
    private final int level;
    private final int capacity;

    // The single source of truth!
    private final ConcurrentHashMap<K, CacheNode<K, V>> map;

    // DLL Pointers
    private final CacheNode<K, V> dummyHead;
    private final CacheNode<K, V> dummyTail;

    // Our "Transaction Manager"
    private final ReentrantLock lock;

    private final UnifiedCacheLevel<K, V> nextCache;
    private final CacheAccessTime accessTime;

    public UnifiedCacheLevel(int level, int capacity, UnifiedCacheLevel<K, V> nextCache, int readTime, int writeTime) {
        this.level = level;
        this.capacity = capacity;
        this.map = new ConcurrentHashMap<>();

        this.dummyHead = new CacheNode<>(null, null);
        this.dummyTail = new CacheNode<>(null, null);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;

        this.lock = new ReentrantLock();
        this.nextCache = nextCache;
        this.accessTime = new CacheAccessTime(readTime, writeTime);
    }

    public ReadResponse<V> get(K key) {
        ReadResponse<V> response = new ReadResponse<>();
        response.totalTime += accessTime.readTime;

        // --- START TRANSACTION ---
        lock.lock();
        try {
            CacheNode<K, V> node = map.get(key);

            if (node != null) {
                // HIT: Atomically update LRU
                moveToHead(node);
                response.val = node.value;
                response.level = this.level;
                return response;
            }
        } finally {
            lock.unlock();
        }
        // --- END TRANSACTION ---

        // MISS: Cascade down the chain (outside the lock to prevent blocking the whole cache!)
        if (nextCache != null) {
            ReadResponse<V> nextResp = nextCache.get(key);
            response.val = nextResp.val;
            response.totalTime += nextResp.totalTime;
            response.level = nextResp.level;

            // Backfill if found lower down
            if (nextResp.val != null) {
                // We do a local put, which has its own lock
                int writeTime = this.putLocal(key, nextResp.val);
                response.totalTime += writeTime;
            }
        }
        return response;
    }

    public WriteResponse put(K key, V value) {
        WriteResponse response = new WriteResponse();

        // 1. Write to this level atomically
        response.totalTime += putLocal(key, value);

        // 2. Write-Through to next level
        if (nextCache != null) {
            WriteResponse nextResp = nextCache.put(key, value);
            response.totalTime += nextResp.totalTime;
        }
        return response;
    }

    /**
     * Internal helper to handle the atomic Map + DLL updates
     */
    private int putLocal(K key, V value) {
        // --- START TRANSACTION ---
        lock.lock();
        try {
            CacheNode<K, V> node = map.get(key);

            if (node != null) {
                // Update existing
                node.value = value;
                moveToHead(node);
            } else {
                // Insert new
                CacheNode<K, V> newNode = new CacheNode<>(key, value);
                map.put(key, newNode);
                addToHead(newNode);

                // Evict if over capacity
                if (map.size() > capacity) {
                    CacheNode<K, V> tail = removeTail();
                    map.remove(tail.key);
                }
            }
            return accessTime.writeTime;
        } finally {
            lock.unlock();
        }
        // --- END TRANSACTION ---
    }

    // --- DLL Helper Methods (Must be called inside a lock) ---
    private void addToHead(CacheNode<K, V> node) {
        node.prev = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    private void removeNode(CacheNode<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(CacheNode<K, V> node) {
        removeNode(node);
        addToHead(node);
    }

    private CacheNode<K, V> removeTail() {
        CacheNode<K, V> realTail = dummyTail.prev;
        removeNode(realTail);
        return realTail;
    }
}
