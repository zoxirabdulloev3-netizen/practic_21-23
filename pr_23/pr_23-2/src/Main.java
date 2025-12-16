public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тест LinkedQueue ===");
        Queue q1 = new LinkedQueue();
        testQueue(q1);

        System.out.println("\n=== Тест ArrayQueue ===");
        Queue q2 = new ArrayQueue(3);
        testQueue(q2);
    }

    private static void testQueue(Queue q) {
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        System.out.println("Размер: " + q.size());
        System.out.println("Первый: " + q.element());

        System.out.print("Удаляем: ");
        while (!q.isEmpty()) {
            System.out.print(q.dequeue() + " ");
        }
        System.out.println("\nПусто: " + q.isEmpty());
    }
}