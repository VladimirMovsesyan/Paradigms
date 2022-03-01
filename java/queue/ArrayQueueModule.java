package queue;

import java.util.Arrays;

public class ArrayQueueModule {
    private static Object[] elements = new Object[10];
    private static int head = 0;
    private static int tail = 0;

    public static void enqueue(Object element) {
        elements[head++] = element;
        ensureArraySize();
    }

    private static void ensureArraySize() {
        if (elements.length <= head) {
            elements = Arrays.copyOf(elements, head * 2);
        }
    }

    public static Object element() {
        return elements[tail];
    }

    public static Object dequeue() {
        Object result = elements[tail++];
        elements[tail - 1] = null;
        return result;
    }

    public static int size() {
        return head - tail;
    }

    public static boolean isEmpty() {
        return tail == head;
    }

    public static void clear() {
        tail = head = 0;
        elements = new Object[10];
    }
}
