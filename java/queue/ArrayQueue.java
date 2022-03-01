package queue;

import java.util.Arrays;

public class ArrayQueue {
    private Object[] elements = new Object[10];
    private int rightSize = 0;
    private int leftSize = 0;

    public void enqueue(Object element) {
        this.elements[this.rightSize++] = element;
        ensureArraySize();
    }

    private void ensureArraySize() {
        if (this.elements.length <= this.rightSize) {
            this.elements = Arrays.copyOf(this.elements, this.rightSize * 2);
        }
    }

    public Object element() {
        return this.elements[this.leftSize];
    }

    public Object dequeue() {
        return this.elements[this.leftSize++];
    }

    public int size() {
        return this.rightSize - this.leftSize;
    }

    public boolean isEmpty() {
        return this.leftSize == this.rightSize;
    }

    public void clear() {
        this.leftSize = this.rightSize = 0;
        this.elements = new Object[10];
    }
}
