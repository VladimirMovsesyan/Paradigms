package queue;

import java.util.Arrays;

public class ArrayQueueADT {
    private Object[] elements = new Object[10];
    private int head = 0;
    private int tail = 0;

    public static void enqueue(ArrayQueueADT queue, Object element) {
        queue.elements[queue.head++] = element;
        ensureArraySize(queue);
    }

    private static void ensureArraySize(ArrayQueueADT queue) {
        if (queue.elements.length <= queue.head) {
            queue.elements = Arrays.copyOf(queue.elements, queue.head * 2);
        }
    }

    public static Object element(ArrayQueueADT queue) {
        return queue.elements[queue.tail];
    }

    public static Object dequeue(ArrayQueueADT queue) {
        Object result = queue.elements[queue.tail++];
        queue.elements[queue.tail - 1] = null;
        return result;
    }

    public static int size(ArrayQueueADT queue) {
        return queue.head - queue.tail;
    }

    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.tail == queue.head;
    }

    public static void clear(ArrayQueueADT queue) {
        queue.tail = queue.head = 0;
        queue.elements = new Object[10];
    }
}
