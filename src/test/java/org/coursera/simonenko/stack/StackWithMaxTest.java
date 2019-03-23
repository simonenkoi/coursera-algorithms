package org.coursera.simonenko.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackWithMaxTest extends StackTest<StackWithMax<String>> {

    private static final String TEST_STRING_3 = "TEST_STRING_3";

    @Override
    protected StackWithMax<String> createStack() {
        return new StackWithMax<>();
    }

    @Test
    public void stackShouldHasCorrectMaxAfterPush() {
        stack.push(TEST_STRING_2);
        stack.push(TEST_STRING_3);
        stack.push(TEST_STRING_1);

        String maxElement = stack.getMaxElement();

        assertEquals(TEST_STRING_3, maxElement);
    }

    @Test
    public void stackShouldHasCorrectMaxAfterPop() {
        stack.push(TEST_STRING_2);
        stack.push(TEST_STRING_1);
        stack.push(TEST_STRING_3);
        stack.pop();

        String maxElement = stack.getMaxElement();

        assertEquals(TEST_STRING_2, maxElement);
    }
}
