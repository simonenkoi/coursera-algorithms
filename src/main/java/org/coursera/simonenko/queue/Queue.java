package org.coursera.simonenko.queue;

public interface Queue<E> {

    boolean isEmpty();

    void queue(E item);

    E dequeue();
}
