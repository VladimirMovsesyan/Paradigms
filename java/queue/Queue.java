package queue;

import java.util.function.Predicate;

public interface Queue {
    // Pred: element != null
    // Post: forAll i=head..tail elements[i] != null && last element of queue == element && size = size + 1
    public void enqueue(Object element);

    // Pred: size > 0
    // Post: returns first element in queue
    public Object element();

    // Pred: size > 0
    // Post: returns and pops first element in queue && size = size - 1
    public Object dequeue();

    // Pred: true
    // Post: return size of queue
    public int size();

    // Pred: true
    // Post: return true if queue is empty and false if it's not empty
    public boolean isEmpty();

    // Pred: true
    // Post: Queue is empty
    public void clear();

    // Pred: true
    // Post: if element that satisfies predicate is exist in the queue, than it returns index of first entry in the queue, otherwise returns -1
    public int indexIf(Predicate<Object> predicate);

    // Pred: true
    // Post: if element that satisfies predicate is exist in the queue, than it returns index of first entry in the queue, otherwise returns -1
    public int lastIndexIf(Predicate<Object> predicate);
}
