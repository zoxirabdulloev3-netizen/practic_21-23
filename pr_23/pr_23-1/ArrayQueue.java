//Задача 1
public class ArrayQueue {
    private Object[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int initialCapacity) {
        capacity = initialCapacity;
        data = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Пред: size < capacity
    // Пост: size' == size + 1
    public void enqueue(Object element) {
        if (size == capacity) ensureCapacity();
        rear = (rear + 1) % capacity;
        data[rear] = element;
        size++;
    }

    // Пред: size > 0
    // Пост: возвращает первый элемент
    public Object element() {
        if (isEmpty()) throw new IllegalStateException("Очередь пуста");
        return data[front];
    }

    // Пред: size > 0
    // Пост: size' == size - 1
    public Object dequeue() {
        if (isEmpty()) throw new IllegalStateException("Очередь пуста");
        Object result = data[front];
        data[front] = null;
        front = (front + 1) % capacity;
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Пост: size' == 0
    public void clear() {
        for (int i = 0; i < capacity; i++) data[i] = null;
        front = 0;
        rear = -1;
        size = 0;
    }

    private void ensureCapacity() {
        capacity *= 2;
        Object[] newData = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % size];
        }
        data = newData;
        front = 0;
        rear = size - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[(front + i) % capacity]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}