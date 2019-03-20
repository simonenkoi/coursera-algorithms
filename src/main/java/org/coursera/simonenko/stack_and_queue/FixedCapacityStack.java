package org.coursera.simonenko.stack_and_queue;

public class FixedCapacityStack<E> implements Stack<E> {
    private E[] elements;
    private int size;

    public FixedCapacityStack(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E item) {
        elements[size] = item;
        size++;
    }

    public E pop() {
        --size;
        E item = elements[size];
        elements[size] = null;
        return item;
    }
}
