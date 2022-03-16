package queue;

import java.util.Arrays;

public class ArrayQueueADT {
    private Object[] elements = new Object[10];
    private int tail = 0;
    private int head = 0;
    private int size = 0;


    // Pred: element != null
    // Post: forAll i=head..tail elements[i] != null && elements.length != tail && elements[tail - 1] == element && size = size + 1
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


    // Pred: tail + 1 == head
    // Post: head == 0 && tail = count of elements && forAll i=head..tail elements[i] != null
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

    // Pred: true
    // Post: elements.length != tail
    private static void ensureArraySize(ArrayQueueADT queue) {
        if (queue.elements.length == queue.tail) {
            queue.elements = Arrays.copyOf(queue.elements, 2 * queue.elements.length);
        }
    }

    // Pred: size > 0
    // Post: returns first element in queue
    public static Object element(ArrayQueueADT queue) {
        if (queue.elements[queue.head] == null) {
            queue.head = 0;
        }
        return queue.elements[queue.head];
    }

    // Pred: size > 0
    // Post: returns and pops first element in queue && size = size - 1
    public static Object dequeue(ArrayQueueADT queue) {
        queue.size--;
        if (queue.elements[queue.head] == null) {
            queue.head = 0;
        }
        Object result = queue.elements[queue.head];
        queue.elements[queue.head++] = null;
        return result;
    }

    // Pred: true
    // Post: returns queue size
    public static int size(ArrayQueueADT queue) {
        return queue.size;
    }

    // Pred: true
    // Post return true if queue is empty and false if it's not empty
    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }

    // Pred: true
    // Post: tail = head = size = 0 && elements = new Object[10] && forAll i=0..10 elements[i] == null
    public static void clear(ArrayQueueADT queue) {
        queue.tail = queue.head = queue.size = 0;
        queue.elements = new Object[10];
    }

    // Pred: true
    // Post: if element is exist in queue, then return it's first position, else return -1;
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

    // Pred: true
    // Post: if element is exist in queue, then return it's last position, else return -1;
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
