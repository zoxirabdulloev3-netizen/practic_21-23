public interface Queue {
    void enqueue(Object item);
    Object element();
    Object dequeue();
    int size();
    boolean isEmpty();
    void clear();
}
