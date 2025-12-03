public class Main {
    public static void main(String[] args) {
        System.out.println("=== ArrayQueueModule ===");
        ArrayQueueModule.enqueue("First");
        ArrayQueueModule.enqueue("Second");
        System.out.println("Размер: " + ArrayQueueModule.size());
        System.out.println("Первый: " + ArrayQueueModule.element());
        System.out.println("Удалён: " + ArrayQueueModule.dequeue());

        System.out.println("\n=== ArrayQueueADT ===");
        ArrayQueueADT queueADT = new ArrayQueueADT();
        ArrayQueueADT.enqueue(queueADT, 100);
        ArrayQueueADT.enqueue(queueADT, 200);
        System.out.println("Размер: " + ArrayQueueADT.size(queueADT));

        System.out.println("\n=== ArrayQueue ===");
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println(queue);
        System.out.println("Удалён: " + queue.dequeue());
        System.out.println("Теперь: " + queue);
    }
}