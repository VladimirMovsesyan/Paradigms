package queue;

import java.util.Arrays;

public class ArrayQueueModule {
    private static Object[] elements = new Object[10];
    private static int tail = 0;
    private static int head = 0;
    private static int size = 0;

    public static void enqueue(Object element) {
        size++;
        if (tail + 1 == head) {
            restructElements();
        }
        if (elements[0] == null && head > 1) {
            tail = 0;
        }
        elements[tail++] = element;
        ensureArraySize();
    }

    private static void restructElements() {
        Object[] temp = new Object[elements.length];
        int index = 0;

        for (int i = head; i != tail; i++, index++) {
            if (elements[i] == null) {
                i = 0;
            }
            temp[index] = elements[i];
        }
        elements = temp;
        head = 0;
        tail = index;
    }

    private static void ensureArraySize() {
        if (elements.length == tail) {
            elements = Arrays.copyOf(elements, 2 * elements.length);
        }
    }

    public static Object element() {
        if (elements[head] == null) {
            head = 0;
        }
        return elements[head];
    }

    public static Object dequeue() {
        size--;
        if (elements[head] == null) {
            head = 0;
        }
        Object result = elements[head];
        elements[head++] = null;
        return result;
    }

    public static int size() {
        return size;
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public static void clear() {
        tail = head = size = 0;
        elements = new Object[10];
    }

    public static Object indexOf(Object element) {
        for (int i = head, index = 0; i != tail; i++, index++) {
            if (elements[i] == null) {
                i = 0;
            }
            if (elements[i].equals(element)) {
                return index;
            }
        }
        return -1;
    }

    public static Object lastIndexOf(Object element) {
        int result = -1;
        for (int i = head, index = 0; i != tail; i++, index++) {
            if (elements[i] == null) {
                i = 0;
            }
            if (elements[i].equals(element)) {
                result = index;
            }
        }
        return result;
    }
}
