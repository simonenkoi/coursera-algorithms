package org.coursera.simonenko.stack_and_queue;

public class LinkedStack<E> implements Stack<E> {
    private Node first;

    private class Node {
        E item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(E item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public E pop() {
        E item = first.item;
        first = first.next;
        return item;
    }
}
