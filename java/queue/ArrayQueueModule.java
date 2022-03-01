package queue;

import java.util.Arrays;

public class ArrayQueueModule {
    private static Object[] elements = new Object[10];
    private static int rightSize = 0;
    private static int leftSize = 0;

    public static void enqueue(Object element) {
        elements[rightSize++] = element;
        ensureArraySize();
    }

    private static void ensureArraySize() {
        if (elements.length <= rightSize) {
            elements = Arrays.copyOf(elements, rightSize * 2);
        }
    }

    public static Object element() {
        return elements[leftSize];
    }

    public static Object dequeue() {
        return elements[leftSize++];
    }

    public static int size() {
        return rightSize - leftSize;
    }

    public static boolean isEmpty() {
        return leftSize == rightSize;
    }

    public static void clear() {
        leftSize = rightSize = 0;
        elements = new Object[10];
    }
}
