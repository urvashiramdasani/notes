package DesignMultiLevelCache;

import java.util.HashMap;

class LruEvictionPolicy<K> implements EvictionPolicy<K> {
    private final HashMap<K, Node<K>> map;
    private final DoublyLinkedList<K> dll;

    public LruEvictionPolicy() {
        this.map = new HashMap<>();
        this.dll = new DoublyLinkedList<>();
    }

    @Override
    public K evictKey() {
        Node<K> node = dll.getLastNode();
        if (node == null) return null;

        dll.deleteNode(node);
        map.remove(node.key);
        return node.key;
    }

    @Override
    public void keyAccessed(K key) {
        Node<K> node = map.get(key);
        if (node == null) {
            Node<K> newNode = new Node<>(key);
            map.put(key, newNode);
            dll.addNodeAtFirst(newNode);
        } else {
            dll.deleteNode(node);
            dll.addNodeAtFirst(node);
        }
    }
}
