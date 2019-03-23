package org.coursera.simonenko.stack;

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

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return elements[size - 1];
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        --size;
        E item = elements[size];
        elements[size] = null;
        return item;
    }
}
