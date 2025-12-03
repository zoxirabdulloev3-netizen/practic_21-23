class MyStack<T> {
    private Object[] data;
    private int top = -1;

    MyStack(int cap) { data = new Object[cap]; }
    void push(T v) { data[++top] = v; }
    T pop() {
        if (top < 0) throw new RuntimeException("POP из пустого стека");
        @SuppressWarnings("unchecked") T v = (T) data[top];
        data[top--] = null;
        return v;
    }
    boolean isEmpty() { return top == -1; }
    int size() { return top + 1; }
}

