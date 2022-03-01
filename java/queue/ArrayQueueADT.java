package queue;

import java.util.Arrays;

public class ArrayQueueADT {
    private Object[] elements = new Object[10];
    private int rightSize = 0;
    private int leftSize = 0;

    public static void enqueue(ArrayQueueADT queue, Object element) {
        queue.elements[queue.rightSize++] = element;
        ensureArraySize(queue);
    }

    private static void ensureArraySize(ArrayQueueADT queue) {
        if (queue.elements.length <= queue.rightSize) {
            queue.elements = Arrays.copyOf(queue.elements, queue.rightSize * 2);
        }
    }

    public static Object element(ArrayQueueADT queue) {
        return queue.elements[queue.leftSize];
    }

    public static Object dequeue(ArrayQueueADT queue) {
        return queue.elements[queue.leftSize++];
    }

    public static int size(ArrayQueueADT queue) {
        return queue.rightSize - queue.leftSize;
    }

    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.leftSize == queue.rightSize;
    }

    public static void clear(ArrayQueueADT queue) {
        queue.leftSize = queue.rightSize = 0;
        queue.elements = new Object[10];
    }
}
