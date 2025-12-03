
public class ArrayQueueModule {
    private static final int DEFAULT_CAPACITY = 10;
    private static Object[] data = new Object[DEFAULT_CAPACITY];
    private static int front = 0;
    private static int rear = -1;
    private static int size = 0;
    private static int capacity = DEFAULT_CAPACITY;

    // Пред: size < capacity
    // Пост: size' == size + 1, rear' указывает на новый элемент
    public static void enqueue(Object element) {
        if (size == capacity) ensureCapacity();
        rear = (rear + 1) % capacity;
        data[rear] = element;
        size++;
    }

    // Пред: size > 0
    // Пост: возвращает первый элемент, очередь не изменяется
    public static Object element() {
        if (isEmpty()) throw new IllegalStateException("Очередь пуста");
        return data[front];
    }

    // Пред: size > 0
    // Пост: size' == size - 1, front' сдвинут, возвращён удалённый элемент
    public static Object dequeue() {
        if (isEmpty()) throw new IllegalStateException("Очередь пуста");
        Object result = data[front];
        data[front] = null;
        front = (front + 1) % capacity;
        size--;
        return result;
    }

    public static int size() {
        return size;
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    // Пост: size' == 0, front == 0, rear == -1
    public static void clear() {
        for (int i = 0; i < capacity; i++) data[i] = null;
        front = 0;
        rear = -1;
        size = 0;
    }

    private static void ensureCapacity() {
        capacity *= 2;
        Object[] newData = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % size];
        }
        data = newData;
        front = 0;
        rear = size - 1;
    }
}