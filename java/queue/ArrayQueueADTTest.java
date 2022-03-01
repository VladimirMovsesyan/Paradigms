package queue;

public class ArrayQueueADTTest {
    public static void main(String[] args) {
        ArrayQueueADT queue1 = new ArrayQueueADT();
        ArrayQueueADT queue2 = new ArrayQueueADT();
        for (int i = 0; i < 20; i++) {
            ArrayQueueADT.enqueue(queue1, i + 1);
            ArrayQueueADT.enqueue(queue2, i + 1);
        }

        for (; !ArrayQueueADT.isEmpty(queue1) || !ArrayQueueADT.isEmpty(queue2);) {
            System.out.println(ArrayQueueADT.size(queue1) + " " + ArrayQueueADT.dequeue(queue1));
            System.out.println(ArrayQueueADT.size(queue2) + " " + ArrayQueueADT.dequeue(queue2));
        }
    }
}
