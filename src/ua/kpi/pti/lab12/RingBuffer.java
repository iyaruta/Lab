package ua.kpi.pti.lab12;

public class RingBuffer {

    private Object[] elements;
    private int size;
    private int index;

    private final Object readLock = new Object();
    private final Object writeLock = new Object();

    public RingBuffer(int capacity) {
        this.elements = new Object[capacity];
    }

    public void add(Object e) throws InterruptedException {
        synchronized (writeLock) {
            if (isFull()) {
                System.out.println("Write wait");
                writeLock.wait();
            }
            elements[size] = e;
            size++;
        }
        synchronized (readLock) {
            readLock.notify();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return elements.length == size;
    }

    public void clear() {
        synchronized (writeLock) {
            elements = new Object[elements.length];
            size = 0;
            writeLock.notifyAll();
        }
    }

    public Object peek() throws InterruptedException {
        synchronized (readLock) {
            if (size == 0) {
                readLock.wait();
            }
            if (index >= size) {
                index = 0;
            }
            Object result = elements[index];
            index++;
            return result;
        }
    }
}
