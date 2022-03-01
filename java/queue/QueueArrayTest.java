package queue;

public class QueueArrayTest {
    public static void main(String[] args) {
        ArrayQueue queue1 = new ArrayQueue();
        ArrayQueue queue2 = new ArrayQueue();
        for (int i = 0; i < 20; i++) {
            queue1.enqueue(i + 1);
            queue2.enqueue(i + 1);
        }

        for (; !queue1.isEmpty() || !queue2.isEmpty();) {
            System.out.println(queue1.size() + " " + queue1.dequeue());
            System.out.println(queue2.size() + " " + queue2.dequeue());
        }
    }
}
