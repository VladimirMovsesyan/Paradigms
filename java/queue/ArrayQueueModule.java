package queue;

import java.util.Arrays;

public class ArrayQueueModule {
    private static Object[] elements = new Object[10];
    private static int tail = 0;
    private static int head = 0;
    private static int size = 0;

    // Pred: element != null
    // Post: forAll i=head..tail elements[i] != null && elements.length != tail && elements[tail - 1] == element && size = size + 1
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

    // Pred: tail + 1 == head
    // Post: head == 0 && tail = count of elements && forAll i=head..tail elements[i] != null
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

    // Pred: true
    // Post: elements.length != tail
    private static void ensureArraySize() {
        if (elements.length == tail) {
            elements = Arrays.copyOf(elements, 2 * elements.length);
        }
    }

    // Pred: size > 0
    // Post: returns first element in queue
    public static Object element() {
        if (elements[head] == null) {
            head = 0;
        }
        return elements[head];
    }

    // Pred: size > 0
    // Post: returns and pops first element in queue && size = size - 1
    public static Object dequeue() {
        size--;
        if (elements[head] == null) {
            head = 0;
        }
        Object result = elements[head];
        elements[head++] = null;
        return result;
    }

    // Pred: true
    // Post: returns queue size
    public static int size() {
        return size;
    }

    // Pred: true
    // Post return true if queue is empty and false if it's not empty
    public static boolean isEmpty() {
        return size == 0;
    }

    // Pred: true
    // Post: tail = head = size = 0 && elements = new Object[10] && forAll i=0..10 elements[i] == null
    public static void clear() {
        tail = head = size = 0;
        elements = new Object[10];
    }

    // Pred: true
    // Post: if element is exist in queue, then return it's first position, else return -1;
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

    // Pred: true
    // Post: if element is exist in queue, then return it's last position, else return -1;
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
