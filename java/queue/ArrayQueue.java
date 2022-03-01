package queue;

import java.util.Arrays;

public class ArrayQueue {
    private Object[] elements = new Object[10];
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public void enqueue(Object element) {
        if (head == tail && size != 0) {
            restructElements();
        }
        size++;
        if (elements[0] == null) {
            head = 0;
        }
        elements[head++] = element;
        ensureArraySize();
    }

    private void restructElements() {
        Object[] temp = new Object[Math.max(size * 2, 10)];
        int ind = 0;
        if (elements[tail] != null) {
            temp[ind++] = elements[tail];
        }
        for (int i = tail + 1; i != head; i++) {
            if (elements[i] == null) {
                i = 0;
            }
            temp[ind++] = elements[i];
        }
        elements = temp;
        head = ind;
        tail = 0;
    }

    private void ensureArraySize() {
        if (elements.length <= head) {
            elements = Arrays.copyOf(elements, head * 2);
        }
    }

    public Object element() {
        if (elements[tail] == null) {
            tail = 0;
        }
        return elements[tail];
    }

    public Object dequeue() {
        size--;
        Object result = elements[tail++];
        elements[tail - 1] = null;
        if (elements[tail] == null) {
            tail = 0;
        }
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        tail = head = size = 0;
        elements = new Object[10];
    }
}
