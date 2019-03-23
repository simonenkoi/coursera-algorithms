package org.coursera.simonenko.queue;

public class TwoStackQueueTest extends QueueTest<TwoStackQueue<String>> {

    @Override
    protected TwoStackQueue<String> createQueue() {
        return new TwoStackQueue<>();
    }
}
