package queue;

import java.util.function.Predicate;
import java.util.Random;


public class TestQueue {
    static void testRandom() {
        Random rnd = new Random();

        Queue q1 = new ArrayQueue();
        Queue q2 = new LinkedQueue();

        final int testCases = 10000;
        Object[] testArray = new Object[testCases];

        for (int i = 0; i < testCases; i++) {
            testArray[i] = rnd.nextInt();
            q1.enqueue(testArray[i]);
            q2.enqueue(testArray[i]);
        }

        int cnt = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (!q1.element().equals(q2.element()) || !q1.element().equals(testArray[cnt])) {
                System.out.println(q1.element() + " " + q2.element() + " " + testArray[cnt]);
                break;
            }

            cnt++;
            q1.dequeue();
            q2.dequeue();
        }
    }

    static public void smallTests(Queue q) {
        q.enqueue(1);
        if (!q.element().equals(1)) {
            System.out.println("element method doesn't work");
        }
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(6);
        q.enqueue(6);

        Predicate<Object> isSix = elem -> elem.equals(6);
        if (q.countIf(isSix) != 3) {
            System.out.println("countIf doesn't work");
            return;
        }

        if (q.size() != 8) {
            System.out.println("size is not eight");
            return;
        }

        if (q.count(6) != 3) {
            System.out.println(q.count(6) + "method count doesn't work");
            return;
        }

        q.clear();
        if (q.size() != 0) {
            System.out.println("size is not zero after clear");
            return;
        }

        if (q.count(1) != 0) {
            System.out.println("method doesn't clear doesn't work properly");
            return;
        }
        // I wish I could use junit test, but unfotunatelly it's ain't allowed :(
    }

    public static void main(String[] args) {
        Queue q1 = new ArrayQueue();
        Queue q2 = new LinkedQueue();

        smallTests(q1);
        smallTests(q2);

        testRandom();
    }
}
