package org.coursera.simonenko.stack_and_queue;

public class ResizingStackTest extends StackTest<ResizingStack<String>> {

    @Override
    protected ResizingStack<String> createStack() {
        return new ResizingStack<>();
    }
}
