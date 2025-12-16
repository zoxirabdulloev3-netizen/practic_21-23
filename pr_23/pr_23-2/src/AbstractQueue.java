public abstract class AbstractQueue implements Queue {
    protected int size;

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    protected void checkNotEmpty() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
    }
}