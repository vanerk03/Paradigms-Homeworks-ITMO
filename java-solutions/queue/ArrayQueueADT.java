package queue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayQueueADT {
    private Map<Object, Integer> mp = new HashMap<>();
    private Object[] array = new Object[5];
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public static int count(ArrayQueueADT queue, final Object elem) {
        assert elem != null;
        return queue.mp.getOrDefault(elem, 0);
    }

    public static Object element(ArrayQueueADT queue) {
        assert !isEmpty(queue);
        return queue.array[queue.head];
    }

    public static Object dequeue(ArrayQueueADT queue) {
        assert queue.n > 0;
        final Object result = queue.array[queue.head];
        queue.mp.put(result, queue.mp.get(result) - 1);
        queue.array[queue.head] = null;
        queue.head++;
        queue.n--;
        if (queue.head == queue.array.length) {
            queue.head = 0;
        }

        return result;
    }

    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.n == 0;
    }

    public static void enqueue(ArrayQueueADT queue, final Object elem) {
        assert elem != null;
        ensureSize(queue, queue.n + 1);
        queue.n++;
        queue.array[queue.tail++] = elem;
        queue.mp.put(elem, queue.mp.containsKey(elem) ? queue.mp.get(elem) + 1 : 1);

        if (queue.tail == queue.array.length) {
            queue.tail = 0;
        }
    }

    private static void ensureSize(ArrayQueueADT queue, final int capacity) {
        if (capacity > queue.array.length) {
            queue.array = Arrays.copyOf(toArray(queue), capacity * 2);
            queue.tail = queue.n;
            queue.head = 0;
        }
    }

    public static Object[] toArray(ArrayQueueADT queue) {
        Object[] newArray = new Object[queue.n];
        final int toCopyFirst = Math.min(queue.n, queue.array.length - queue.head);
        System.arraycopy(queue.array, queue.head, newArray, 0, toCopyFirst);
        System.arraycopy(queue.array, 0, newArray, toCopyFirst, queue.n - toCopyFirst);
        return newArray;
    }

    public static void clear(ArrayQueueADT queue) {
        queue.array = new Object[10];
        queue.n = 0;
        queue.tail = 0;
        queue.head = 0;
        queue.mp.clear();
    }

    public static int size(ArrayQueueADT queue) {
        return queue.n;
    }

}
