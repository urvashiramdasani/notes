package DesignMultiLevelCache;

class ReadResponse<V> {
    V val;
    Integer totalTime = 0;
    Integer level = -1; // -1 indicates a total cache miss
}
