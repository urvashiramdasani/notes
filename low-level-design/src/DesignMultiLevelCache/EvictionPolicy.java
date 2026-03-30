package DesignMultiLevelCache;

interface EvictionPolicy<K> {
    K evictKey();
    void keyAccessed(K key);
}
