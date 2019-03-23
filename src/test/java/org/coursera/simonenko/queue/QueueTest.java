package org.coursera.simonenko.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class QueueTest<T extends Queue<String>> {

    private static final String TEST_STRING_1 = "TEST_STRING_1";
    private static final String TEST_STRING_2 = "TEST_STRING_2";

    private T queue;

    protected abstract T createQueue();

    @Before
    public void setUp() {
        queue = createQueue();
    }

    @Test
    public void queueIsNotEmptyAfterQueue() {
        queue.queue(TEST_STRING_1);
        boolean empty = queue.isEmpty();

        assertFalse(empty);
    }

    @Test
    public void elementThatIsQueuededShouldBeDequeued() {
        queue.queue(TEST_STRING_1);
        String actual = queue.dequeue();

        assertEquals(TEST_STRING_1, actual);
    }

    @Test
    public void queueIsEmptyAfterQueueAndDequeue() {
        queue.queue(TEST_STRING_1);
        queue.dequeue();
        boolean empty = queue.isEmpty();

        assertTrue(empty);
    }

    @Test
    public void elementsShouldBeInFifoOrder() {
        queue.queue(TEST_STRING_1);
        queue.queue(TEST_STRING_2);
        String element1 = queue.dequeue();
        String element2 = queue.dequeue();

        assertEquals(TEST_STRING_1, element1);
        assertEquals(TEST_STRING_2, element2);
    }
}