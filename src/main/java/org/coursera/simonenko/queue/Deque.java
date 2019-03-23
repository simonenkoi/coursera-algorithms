package org.coursera.simonenko.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<E> implements Iterable<E> {

    private Node first;
    private Node last;
    private int size;

    private class Node {

        private E item;
        private Node next;
        private Node previous;

        private Node(E item) {
            this.item = item;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(E item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            first = new Node(item);
            last = first;
        } else {
            Node oldFirst = first;
            first = new Node(item);
            first.next = oldFirst;
            oldFirst.previous = first;
        }

        ++size;
    }

    public void addLast(E item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (isEmpty()) {
            first = new Node(item);
            last = first;
        } else {
            Node oldLast = last;
            last = new Node(item);
            oldLast.next = last;
            last.previous = oldLast;
        }

        ++size;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E item = first.item;
        first = first.next;
        --size;
        return item;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E item = last.item;
        last = last.previous;
        --size;
        return item;
    }

    @Override
    public Iterator<E> iterator() {
        // LIFO
        return new Iterator<E>() {
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E item = current.item;
                current = current.next;
                return item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
