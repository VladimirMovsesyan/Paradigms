package queue;

import java.util.Arrays;

public class ArrayQueueADT {
    private Object[] elements = new Object[10];
    private int tail = 0;
    private int head = 0;
    private int size = 0;

    public static void enqueue(ArrayQueueADT queue, Object element) {
        queue.size++;
        if (queue.tail + 1 == queue.head) {
            restructElements(queue);
        }
        if (queue.elements[0] == null && queue.head > 1) {
            queue.tail = 0;
        }
        queue.elements[queue.tail++] = element;
        ensureArraySize(queue);
    }

    private static void restructElements(ArrayQueueADT queue) {
        Object[] temp = new Object[queue.elements.length];
        int index = 0;

        for (int i = queue.head; i != queue.tail; i++, index++) {
            if (queue.elements[i] == null) {
                i = 0;
            }
            temp[index] = queue.elements[i];
        }
        queue.elements = temp;
        queue.head = 0;
        queue.tail = index;
    }

    private static void ensureArraySize(ArrayQueueADT queue) {
        if (queue.elements.length == queue.tail) {
            queue.elements = Arrays.copyOf(queue.elements, 2 * queue.elements.length);
        }
    }

    public static Object element(ArrayQueueADT queue) {
        if (queue.elements[queue.head] == null) {
            queue.head = 0;
        }
        return queue.elements[queue.head];
    }

    public static Object dequeue(ArrayQueueADT queue) {
        queue.size--;
        if (queue.elements[queue.head] == null) {
            queue.head = 0;
        }
        Object result = queue.elements[queue.head];
        queue.elements[queue.head++] = null;
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

    public static Object indexOf(ArrayQueueADT queue, Object element) {
        for (int i = queue.head, index = 0; i != queue.tail; i++, index++) {
            if (queue.elements[i] == null) {
                i = 0;
            }
            if (queue.elements[i].equals(element)) {
                return index;
            }
        }
        return -1;
    }

    public static Object lastIndexOf(ArrayQueueADT queue, Object element) {
        int result = -1;
        for (int i = queue.head, index = 0; i != queue.tail; i++, index++) {
            if (queue.elements[i] == null) {
                i = 0;
            }
            if (queue.elements[i].equals(element)) {
                result = index;
            }
        }
        return result;
    }
}
