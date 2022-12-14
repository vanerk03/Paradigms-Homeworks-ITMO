package queue;

public class LinkedQueue extends AbstractQueue {
    private Node head;
    private Node tail;

    @Override
    public Object elementImpl() {
        return head.value;
    }

    @Override
    public Object dequeueImpl() {
        assert n > 0;
        final Object result = head.value;
        head = head.next;
        return result;
    }

    @Override
    public void enqueueImpl(final Object elem) {
        final Node newNode = new Node(elem, null);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail = tail.connect(newNode);
        }
        n++;
    }

    @Override
    public Object[] toArrayImpl() {
        Object[] newArray = new Object[n];
        Node currentNode = head;
        for (int i = 0; i < n; i++) {
            newArray[i] = currentNode.value;
            currentNode = currentNode.next;
        }
        return newArray;
    }

    @Override
    public void clearImpl() {
        head = null;
        tail = null;
    }

    private static class Node {
        private Object value;
        private Node next;

        public Node(final Object value, final Node next) {
            assert value != null;
            this.value = value;
            this.next = next;
        }

        public Node connect(final Node newNode) {
            next = newNode;
            return newNode;
        }
    }
}