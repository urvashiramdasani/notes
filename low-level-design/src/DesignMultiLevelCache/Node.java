package DesignMultiLevelCache;

class Node<K> {
    K key;
    Node<K> next = null;
    Node<K> previous = null;

    public Node(K key) {
        this.key = key;
    }
}
