public class ArrayQueue extends AbstractQueue {
    private Object[] items;
    private int front;
    private int rear;
    private int capacity;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        items = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(Object item) {
        if (size == capacity) resize();
        rear = (rear + 1) % capacity;
        items[rear] = item;
        size++;
    }

    public Object element() {
        checkNotEmpty();
        return items[front];
    }

    public Object dequeue() {
        checkNotEmpty();
        Object item = items[front];
        items[front] = null;
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) items[i] = null;
        front = 0;
        rear = -1;
        size = 0;
    }

    private void resize() {
        capacity *= 2;
        Object[] newItems = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newItems[i] = items[(front + i) % items.length];
        }
        items = newItems;
        front = 0;
        rear = size - 1;
    }
}