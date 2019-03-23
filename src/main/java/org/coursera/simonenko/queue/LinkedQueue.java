package org.coursera.simonenko.queue;

import org.coursera.simonenko.stack.Node;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> first;
    private Node<E> last;

    public boolean isEmpty() {
        return first == null;
    }

    public void queue(E item) {
        Node<E> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public E dequeue() {
        E item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }
}
