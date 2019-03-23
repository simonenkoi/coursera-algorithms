package org.coursera.simonenko.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DequeTest {

    private static final String TEST_STRING_1 = "TEST_STRING_1";
    private Deque<String> deque;

    @Before
    public void init() {
        deque = new Deque<>();
    }

    @Test
    public void emptyDequeMustBeEmpty() {
        assertTrue(deque.isEmpty());
    }

    @Test
    public void emptyDequeMustHaveZeroSize() {
        assertEquals(0, deque.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addFirstOfNullElementMustThrowException() {
        deque.addFirst(null);
    }

    @Test
    public void dequeMustNotBeEmptyAfterAddFirst() {
        deque.addFirst(TEST_STRING_1);

        assertFalse(deque.isEmpty());
    }

    @Test
    public void dequeMustHaveSizeOneAfterAddFirst() {
        deque.addFirst(TEST_STRING_1);

        assertEquals(1, deque.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addLastOfNullElementMustThrowException() {
        deque.addLast(null);
    }

    @Test
    public void dequeMustNotBeEmptyAfterAddLast() {
        deque.addLast(TEST_STRING_1);

        assertFalse(deque.isEmpty());
    }

    @Test
    public void dequeMustHaveSizeOneAfterAddLast() {
        deque.addLast(TEST_STRING_1);

        assertEquals(1, deque.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void removeFirstOnEmptyDequeMustThrowException() {
        deque.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void removeLastOnEmptyDequeMustThrowException() {
        deque.removeLast();
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorNextOfEmptyDequeMustThrowException() {
        deque.iterator().next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iteratorRemoveOfDequeMustThrowException() {
        deque.iterator().remove();
    }
}