package org.coursera.simonenko.stack;

public class LinkedStackTest extends StackTest<LinkedStack<String>> {

    @Override
    protected LinkedStack<String> createStack() {
        return new LinkedStack<>();
    }
}
