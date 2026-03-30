package DesignMultiLevelCache;

class Cache<K, V> {
    private final Integer level;
    private final EvictionPolicy<K> evictionPolicy;
    private final Storage<K, V> storage;
    private final CacheAccessTime cacheAccessTime;
    private final Cache<K, V> nextCache;

    Cache(EvictionPolicy<K> evictionPolicy, Storage<K, V> storage, Integer level, Cache<K, V> nextCache, Integer readTime, Integer writeTime) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
        this.level = level;
        this.nextCache = nextCache;
        this.cacheAccessTime = new CacheAccessTime(readTime, writeTime);
    }

    public ReadResponse<V> get(K key) {
        ReadResponse<V> response = new ReadResponse<>();
        response.totalTime += cacheAccessTime.readTime;

        // 1. Check current level
        V value = storage.get(key);
        if (value != null) {
            // HIT! Update LRU and return
            evictionPolicy.keyAccessed(key);
            response.val = value;
            response.level = this.level;
            return response;
        }

        // 2. MISS! Check next level down the chain
        if (nextCache != null) {
            ReadResponse<V> nextResponse = nextCache.get(key);
            response.val = nextResponse.val;
            response.totalTime += nextResponse.totalTime;
            response.level = nextResponse.level;

            // 3. BACKFILL: If found in a lower level, bring it up to this level
            if (nextResponse.val != null) {
                if (storage.isFull()) {
                    K evictedKey = evictionPolicy.evictKey();
                    storage.removeKey(evictedKey);
                }
                response.totalTime += cacheAccessTime.writeTime;
                storage.addKey(key, nextResponse.val);
                evictionPolicy.keyAccessed(key); // Safely add to LRU only after adding to storage
            }
        }
        return response;
    }

    public WriteResponse put(K key, V val) {
        WriteResponse response = new WriteResponse();
        response.totalTime += cacheAccessTime.writeTime;

        // 1. Handle Eviction if it's a brand new key and we are full
        if (storage.get(key) == null && storage.isFull()) {
            K evictedKey = evictionPolicy.evictKey();
            storage.removeKey(evictedKey);
        }

        // 2. Add or Update the storage
        storage.addKey(key, val);

        // 3. Update the LRU policy
        evictionPolicy.keyAccessed(key);

        // 4. WRITE-THROUGH: Always propagate down the chain!
        if (nextCache != null) {
            WriteResponse nextResponse = nextCache.put(key, val);
            response.totalTime += nextResponse.totalTime;
        }

        return response;
    }
}