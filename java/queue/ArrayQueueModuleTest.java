package queue;

public class ArrayQueueModuleTest {
    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            ArrayQueueModule.enqueue(i + 1);
        }

        for (; !ArrayQueueModule.isEmpty();) {
            System.err.println(ArrayQueueModule.size() + " " + ArrayQueueModule.dequeue());
        }
    }
}
