package queue;

import java.util.Arrays;

import java.util.HashMap;
import java.util.Map;

public class ArrayQueueModule {
    private static final Map<Object, Integer> mp = new HashMap<>();
    private static Object[] array = new Object[5];
    private static int n = 0;
    private static int head = 0;
    private static int tail = 0;

    public static int count(final Object elem) {
        assert elem != null;
        return mp.getOrDefault(elem, 0);
    }

    public static Object element() {
        assert !isEmpty();
        return array[head];
    }

    public static Object dequeue() {
        assert n > 0;
        final Object result = array[head];
        mp.put(result, mp.get(result) - 1);
        array[head] = null;
        head++;
        n--;
        if (head == array.length) {
            head = 0;
        }

        return result;
    }

    public static boolean isEmpty() {
        return n == 0;
    }

    public static void enqueue(final Object elem) {
        ensureSize(n + 1);
        n++;
        mp.put(elem, mp.containsKey(elem) ? mp.get(elem) + 1 : 1);
        array[tail++] = elem;
        if (tail == array.length) {
            tail = 0;
        }
    }

    private static void ensureSize(final int capacity) {
        if (capacity > array.length) {
            array = Arrays.copyOf(toArray(), capacity * 2);
            tail = n;
            head = 0;
        }
    }

    public static void clear() {
        array = new Object[10];
        n = 0;
        tail = 0;
        head = 0;
        mp.clear();
    }

    public static int size() {
        return n;
    }

    public static Object[] toArray() {
        Object[] newArray = new Object[n];
        final int toCopyFirst = Math.min(n, array.length - head);
        System.arraycopy(array, head, newArray, 0, toCopyFirst);
        System.arraycopy(array, 0, newArray, toCopyFirst, n - toCopyFirst);
        return newArray;
    }
}
