package org.coursera.simonenko.queue;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<E> implements Iterable<E> {

    private E[] elements;
    private int size;

    public RandomizedQueue() {
        elements = (E[]) new Object[1];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(E item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (size == elements.length) {
            resize(2 * elements.length);
        }
        elements[size] = item;
        size++;
    }

    private void resize(int max) {
        assert max >= size;
        E[] temp = (E[]) new Object[max];
        if (size >= 0) {
            System.arraycopy(elements, 0, temp, 0, size);
        }
        elements = temp;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int randIndex = StdRandom.uniform(size);
        E temp = elements[randIndex];
        --size;
        elements[randIndex] = elements[size];
        elements[size] = null;
        if (size > 0 && size == elements.length / 4) {
            resize(elements.length / 2);
        }
        return temp;
    }

    public E sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int randomIndex = StdRandom.uniform(size);
        return elements[randomIndex];
    }

    public Iterator<E> iterator() {
        return new RQIterator();
    }

    private class RQIterator implements Iterator<E> {

        private int i;
        private int[] randIndices;

        public RQIterator() {
            randIndices = new int[size];
            for (int j = 0; j < size; j++) {
                randIndices[j] = j;
            }
            StdRandom.shuffle(randIndices);
        }

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E item = elements[randIndices[i]];
            i++;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
