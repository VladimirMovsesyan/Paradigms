package queue;

import java.util.Arrays;

public class ArrayQueueADT {
    private Object[] elements = new Object[10];
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public static void enqueue(ArrayQueueADT queue, Object element) {
        if (queue.head == queue.tail && queue.size != 0) {
            restructElements(queue);
        }
        queue.size++;
        if (queue.elements[0] == null) {
            queue.head = 0;
        }
        queue.elements[queue.head++] = element;
        ensureArraySize(queue);
    }

    private static void restructElements(ArrayQueueADT queue) {
        Object[] temp = new Object[Math.max(queue.size * 2, 10)];
        int ind = 0;
        if (queue.elements[queue.tail] != null) {
            temp[ind++] = queue.elements[queue.tail];
        }
        for (int i = queue.tail + 1; i != queue.head; i++) {
            if (queue.elements[i] == null) {
                i = 0;
            }
            temp[ind++] = queue.elements[i];
        }
        queue.elements = temp;
        queue.head = ind;
        queue.tail = 0;
    }
    private static void ensureArraySize(ArrayQueueADT queue) {
        if (queue.elements.length <= queue.head) {
            queue.elements = Arrays.copyOf(queue.elements, queue.head * 2);
        }
    }

    public static Object element(ArrayQueueADT queue) {
        if (queue.elements[queue.tail] == null) {
            queue.tail = 0;
        }
        return queue.elements[queue.tail];
    }

    public static Object dequeue(ArrayQueueADT queue) {
        queue.size--;
        Object result = queue.elements[queue.tail++];
        queue.elements[queue.tail - 1] = null;
        if (queue.elements[queue.tail] == null) {
            queue.tail = 0;
        }
        return result;
    }

    public static int size(ArrayQueueADT queue) {
        return queue.size;
    }

    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }

    public static void clear(ArrayQueueADT queue) {
        queue.tail = queue.head = queue.size = 0;
        queue.elements = new Object[10];
    }
}
