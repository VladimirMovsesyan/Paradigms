package queue;

import java.util.Arrays;

public class ArrayQueue {
    private Object[] elements = new Object[10];
    private int head = 0;
    private int tail = 0;

    public void enqueue(Object element) {
        elements[head++] = element;
        ensureArraySize();
    }

    private void ensureArraySize() {
        if (elements.length <= head) {
            elements = Arrays.copyOf(elements, head * 2);
        }
    }

    public Object element() {
        return elements[tail];
    }

    public Object dequeue() {
        Object result = elements[tail++];
        elements[tail - 1] = null;
        return result;
    }

    public int size() {
        return head - tail;
    }

    public boolean isEmpty() {
        return tail == head;
    }

    public void clear() {
        tail = head = 0;
        elements = new Object[10];
    }
}
