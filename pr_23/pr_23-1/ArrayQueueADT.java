/**
 * Абстрактный тип данных "Очередь"
 * Инвариант:
 * 1. 0 <= size <= capacity
 * 2. front указывает на первый элемент, если очередь не пуста
 * 3. rear указывает на последний элемент, если очередь не пуста
 * 4. Элементы хранятся в data[front..rear] циклически
 */
public class ArrayQueueADT {
    private Object[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayQueueADT() {
        this(10);
    }

    public ArrayQueueADT(int initialCapacity) {
        capacity = initialCapacity;
        data = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Пред: queue != null, size < capacity
    // Пост: size' == size + 1
    public static void enqueue(ArrayQueueADT queue, Object element) {
        if (queue.size == queue.capacity) ensureCapacity(queue);
        queue.rear = (queue.rear + 1) % queue.capacity;
        queue.data[queue.rear] = element;
        queue.size++;
    }

    // Пред: queue != null, size > 0
    // Пост: возвращает первый элемент
    public static Object element(ArrayQueueADT queue) {
        if (isEmpty(queue)) throw new IllegalStateException("Очередь пуста");
        return queue.data[queue.front];
    }

    // Пред: queue != null, size > 0
    // Пост: size' == size - 1
    public static Object dequeue(ArrayQueueADT queue) {
        if (isEmpty(queue)) throw new IllegalStateException("Очередь пуста");
        Object result = queue.data[queue.front];
        queue.data[queue.front] = null;
        queue.front = (queue.front + 1) % queue.capacity;
        queue.size--;
        return result;
    }

    public static int size(ArrayQueueADT queue) {
        return queue.size;
    }

    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }

    // Пост: size' == 0
    public static void clear(ArrayQueueADT queue) {
        for (int i = 0; i < queue.capacity; i++) queue.data[i] = null;
        queue.front = 0;
        queue.rear = -1;
        queue.size = 0;
    }

    private static void ensureCapacity(ArrayQueueADT queue) {
        queue.capacity *= 2;
        Object[] newData = new Object[queue.capacity];
        for (int i = 0; i < queue.size; i++) {
            newData[i] = queue.data[(queue.front + i) % queue.size];
        }
        queue.data = newData;
        queue.front = 0;
        queue.rear = queue.size - 1;
    }
}