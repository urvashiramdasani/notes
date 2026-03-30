package DesignMultiLevelCache;

interface Storage<K, V> {
    void addKey(K key, V value);
    void removeKey(K key);
    V get(K key);
    boolean isFull();
}
