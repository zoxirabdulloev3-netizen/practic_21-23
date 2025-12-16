/// Задача  2

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

public class RPNCalc {
    public static double calc(String expr) {
        MyStack<Double> s = new MyStack<>(100);
        for (String t : expr.trim().split("\\s+")) {
            if (t.matches("-?\\d+(\\.\\d+)?")) {
                s.push(Double.parseDouble(t));
            } else {
                if (s.size() < 2) throw new RuntimeException("Недостаточно операндов для " + t);
                double b = s.pop(), a = s.pop();
                s.push(switch(t) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> { if (b == 0) throw new RuntimeException("Деление на ноль"); yield a / b; }
                    case "^" -> Math.pow(a, b);
                    default -> throw new RuntimeException("Неизвестная операция: " + t);
                });
            }
        }
        if (s.size() != 1) throw new RuntimeException("Некорректное выражение");
        return s.pop();
    }

    public static void main(String[] args) {
        String[] tests = {"2 3 +", "5 1 2 + 4 * + 3 -", "1 2 + *", "5 0 /", "1 2 3 +"};
        for (String t : tests) {
            try { System.out.println(t + " = " + calc(t)); }
            catch (Exception e) { System.out.println(t + " -> Ошибка: " + e.getMessage()); }
        }
    }
}
