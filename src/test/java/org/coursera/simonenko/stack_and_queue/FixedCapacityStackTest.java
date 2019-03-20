package org.coursera.simonenko.stack_and_queue;

public class FixedCapacityStackTest extends StackTest<FixedCapacityStack<String>> {

    @Override
    protected FixedCapacityStack<String> createStack() {
        return new FixedCapacityStack<>(10);
    }
}
