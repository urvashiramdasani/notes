package DesignMultiLevelCache;

class DoublyLinkedList<K> {
    private final Node<K> dummyHead;
    private final Node<K> dummyTail;

    public DoublyLinkedList() {
        this.dummyHead = new Node<>(null);
        this.dummyTail = new Node<>(null);
        this.dummyHead.next = dummyTail;
        this.dummyTail.previous = dummyHead;
    }

    public void addNodeAtFirst(Node<K> node) {
        Node<K> nextNode = this.dummyHead.next;
        nextNode.previous = node;
        node.next = nextNode;
        node.previous = this.dummyHead;
        this.dummyHead.next = node;
    }

    public void deleteNode(Node<K> node) {
        Node<K> previous = node.previous;
        Node<K> next = node.next;
        previous.next = next;
        next.previous = previous;
    }

    public Node<K> getLastNode() {
        if (this.dummyTail.previous == this.dummyHead) {
            return null; // List is empty
        }
        return this.dummyTail.previous;
    }
}