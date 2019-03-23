package org.coursera.simonenko.queue;

public class LinkedQueueTest extends QueueTest<LinkedQueue<String>> {

    @Override
    protected LinkedQueue<String> createQueue() {
        return new LinkedQueue<>();
    }
}
