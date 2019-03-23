package org.coursera.simonenko.stack;

public interface Stack<E> {

    boolean isEmpty();

    void push(E item);

    E peek();

    E pop();
}
