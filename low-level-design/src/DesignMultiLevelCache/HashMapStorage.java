package DesignMultiLevelCache;

import java.util.HashMap;

class HashMapStorage<K, V> implements Storage<K, V> {
    private final HashMap<K, V> hashMapStorage;
    private final Integer capacity;

    public HashMapStorage(Integer capacity) {
        this.hashMapStorage = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public void addKey(K key, V value) {
        hashMapStorage.put(key, value);
    }

    @Override
    public V get(K key) {
        return hashMapStorage.get(key);
    }

    @Override
    public void removeKey(K key) {
        hashMapStorage.remove(key);
    }

    @Override
    public boolean isFull() {
        return hashMapStorage.size() >= capacity;
    }
}
