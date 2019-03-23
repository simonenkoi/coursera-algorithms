package org.coursera.simonenko.stack;

public class ResizingStackTest extends StackTest<ResizingStack<String>> {

    @Override
    protected ResizingStack<String> createStack() {
        return new ResizingStack<>();
    }
}
