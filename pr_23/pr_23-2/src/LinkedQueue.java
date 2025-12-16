public class LinkedQueue extends AbstractQueue {
    private static class Node {
        Object value;
        Node next;
        Node(Object value) { this.value = value; }
    }

    private Node head;
    private Node tail;

    public void enqueue(Object item) {
        Node node = new Node(item);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public Object element() {
        checkNotEmpty();
        return head.value;
    }

    public Object dequeue() {
        checkNotEmpty();
        Object value = head.value;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return value;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }
}