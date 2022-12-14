package queue;

import java.util.Arrays;

public class ArrayQueue extends AbstractQueue {
    private Object[] array = new Object[5];
    private int head = 0;
    private int tail = 0;

    @Override
    public Object elementImpl() {
        return array[head];
    }

    @Override
    public Object dequeueImpl() {
        final Object result = array[head];
        array[head] = null;
        head++;
        if (head == array.length) {
            head = 0;
        }
        return result;
    }

    @Override
    public void enqueueImpl(final Object elem) {
        ensureSize(n + 1);
        n++;
        array[tail++] = elem;
        if (tail == array.length) {
            tail = 0;
        }
    }

    private void ensureSize(final int capacity) {
        if (capacity > array.length) {
            array = Arrays.copyOf(toArray(), capacity * 2);
            tail = n;
            head = 0;
        }
    }

    @Override
    public Object[] toArrayImpl() {
        Object[] newArray = new Object[n];
        final int toCopyFirst = Math.min(n, array.length - head);
        System.arraycopy(array, head, newArray, 0, toCopyFirst);
        System.arraycopy(array, 0, newArray, toCopyFirst, n - toCopyFirst);
        return newArray;
    }

    @Override
    public void clearImpl() {
        array = new Object[5];
        tail = 0;
        head = 0;
    }
}