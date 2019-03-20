package org.coursera.simonenko.stack_and_queue;

public interface Queue<E> {

    boolean isEmpty();

    void queue(E item);

    E dequeue();
}
