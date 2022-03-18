package queue;

import java.util.function.Predicate;

public class LinkedQueue extends AbstractQueue {

    private static class Node {
        private Node next;
        private Object element;

        Node(Node next, Object element) {
            this.next = next;
            this.element = element;
        }
    }

    private Node tail = new Node(null, null);
    private Node head = new Node(tail, null);

    @Override
    protected void enqueueImpl(Object element) {
        tail.element = element;
        tail.next = new Node(null, null);
        tail = tail.next;
    }

    @Override
    protected Object elementImpl() {
        if (head.element == null) {
            head = head.next;
        }
        return head.element;
    }

    @Override
    protected Object dequeueImpl() {
        if (head.element == null) {
            head = head.next;
        }
        Object element = head.element;
        head = head.next;
        return element;
    }

    @Override
    protected void clearImpl() {
        tail = new Node(null, null);
        head = new Node(tail, null);
    }
    
    @Override
    public int indexIf(Predicate<Object> predicate) {
        int index = 0;
        for (Node i = head; i != tail; i = i.next, index++) {
            if (i.element == null) {
                index--;
                continue;
            }
            if (predicate.test(i.element)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexIf(Predicate<Object> predicate) {
        int index = 0;
        int result = -1;
        for (Node i = head; i != tail; i = i.next, index++) {
            if (i.element == null) {
                index--;
                continue;
            }
            if (predicate.test(i.element)) {
                result = index;
            }
        }
        return result;
    }
}
