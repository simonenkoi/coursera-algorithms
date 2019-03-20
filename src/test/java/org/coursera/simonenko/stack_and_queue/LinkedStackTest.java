package org.coursera.simonenko.stack_and_queue;

public class LinkedStackTest extends StackTest<LinkedStack<String>> {

    @Override
    protected LinkedStack<String> createStack() {
        return new LinkedStack<>();
    }
}
