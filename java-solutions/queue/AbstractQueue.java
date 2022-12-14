package queue;

import java.util.Map;
import java.util.HashMap;
import java.util.function.Predicate;

public abstract class AbstractQueue implements Queue {
    protected int n;
    protected Map<Object, Integer> mp = new HashMap<>();

    protected abstract Object[] toArrayImpl();

    protected abstract Object dequeueImpl();

    protected abstract void enqueueImpl(final Object elem);

    protected abstract void clearImpl();

    protected abstract Object elementImpl();

    @Override
    public int countIf(final Predicate<Object> p) {
        assert p != null;
        int cnt = 0;
        for (Object elem : toArray()) {
            if (p.test(elem)) {
                cnt++;
            }
        }
        return cnt;
    }

    @Override
    public int count(final Object elem) {
        assert elem != null : "argument should";
        return mp.getOrDefault(elem, 0);
    }

    @Override
    public Object dequeue() {
        assert !isEmpty() : "Queue is empty";
        final Object result = dequeueImpl();
        n--;
        mp.merge(result, -1, Integer::sum);
        mp.remove(result, 0);
        return result;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public void enqueue(final Object elem) {
        assert (elem != null) : "Can't enqueue null";
        mp.putIfAbsent(elem, 0);
        mp.merge(elem, 1, Integer::sum);
        enqueueImpl(elem);
    }

    protected Object[] toArray() {
        return toArrayImpl();
    }

    @Override
    public void clear() {
        n = 0;
        clearImpl();
        mp.clear();
    }

    @Override
    public Object element() {
        assert !isEmpty() : "Queue is empty";
        return elementImpl();
    }
}
