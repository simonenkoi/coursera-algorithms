package org.coursera.simonenko.stack;

public class LinkedStack<E> implements Stack<E> {
    private Node<E> first;

    public boolean isEmpty() {
        return first == null;
    }

    public void push(E item) {
        Node<E> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return first.item;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E item = first.item;
        first = first.next;
        return item;
    }
}
