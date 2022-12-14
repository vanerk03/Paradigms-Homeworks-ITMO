package queue;

import java.util.function.Predicate;

public interface Queue {
    Object dequeue();

    Object element();

    boolean isEmpty();

    void enqueue(final Object x);

    void clear();

    int size();

    int count(final Object x);

    int countIf(final Predicate<Object> p);
}
/*
    Model: 
    a[0]..a[n - 1] where n is current number of elements in queue
    Invariant: for i = 0 .. n - 1: a[i] != null

    Let Immutable(l, r): a[l : r) == a'[l : r)

    Queue:
        * enqueue – add to queue
        * element – first element in the queue
        * dequeue – pop and return head element
        * size – return queue size
        * isEmpty – check if queue is empty
        * clear – clear up queue
        * count - return number of elements that are equal to given
        * countIf - return number of elements for which predicate is true

    1. enqueue(element)

    Pred: element != null
    Post: n' = n + 1 and Immutable(0, n) and a[n'] == element

    2. element
    
    Pred: n > 0
    Post: Immutable(0, n) and R = a[0]
    
    3. dequeue

    Pred: n > 0
    Post: R = a[0] and n' = n - 1 and a' = a[1 : n]

    4. size

    Pred: true
    Post: R = n and Immutable(0, n) 

    5. isEmpty

    Pred: true
    Post: R = (n == 0)

    6. clear

    Pred: true
    Post: n' = 0

    7. count

    Pred: elem != null
    Post: r = |{ i: a[i] == elem }|

    8. countIf

    Pred: p != null
    Post: r = |{ i: p(a[i]) }|
*/
