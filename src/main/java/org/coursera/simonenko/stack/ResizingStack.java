package org.coursera.simonenko.stack;

public class ResizingStack<E> implements Stack<E> {

    private E[] elements;
    private int size;

    public ResizingStack() {
        elements = (E[]) new Object[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E item) {
        if (elements.length == size) {
            resize(2 * elements.length);
        }
        elements[size] = item;
        size++;
    }

    public E peek() {
        if (size == 0) {
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
        if (size > 0 && size == elements.length / 4) {
            resize(elements.length / 2);
        }
        return item;
    }

    private void resize(int capacity) {
        E[] copy = (E[]) new Object[capacity];
        System.arraycopy(elements, 0, copy, 0, size);
        elements = copy;
    }
}
