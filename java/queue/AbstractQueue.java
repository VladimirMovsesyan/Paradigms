package queue;

public abstract class AbstractQueue implements Queue {
    protected int size = 0;
    @Override
    public void enqueue(Object element) {
        size++;
        enqueueImpl(element);
    }
    
    protected abstract void enqueueImpl(Object element);

    @Override
    public Object element() {
        return elementImpl();
    }

    protected abstract Object elementImpl();

    @Override
    public Object dequeue() {
        size--;
        return dequeueImpl();
    }

    protected abstract Object dequeueImpl();

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        clearImpl();
    }

    protected abstract void clearImpl();
}
