package org.coursera.simonenko.stack_and_queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class StackTest<T extends Stack<String>> {

    private static final String TEST_STRING_1 = "TEST_STRING_1";
    private static final String TEST_STRING_2 = "TEST_STRING_2";

    private T stack;

    protected abstract T createStack();

    @Before
    public void setUp() {
        stack = createStack();
    }

    @Test
    public void stackIsNotEmptyAfterPush() {
        stack.push(TEST_STRING_1);
        boolean empty = stack.isEmpty();

        assertFalse(empty);
    }

    @Test
    public void elementThatIsPushedShouldBePoped() {
        stack.push(TEST_STRING_1);
        String actual = stack.pop();

        assertEquals(TEST_STRING_1, actual);
    }

    @Test
    public void stackIsEmptyAfterPushAndPop() {
        stack.push(TEST_STRING_1);
        stack.pop();
        boolean empty = stack.isEmpty();

        assertTrue(empty);
    }

    @Test
    public void elementsShouldBeInLifoOrder() {
        stack.push(TEST_STRING_1);
        stack.push(TEST_STRING_2);
        String element1 = stack.pop();
        String element2 = stack.pop();

        assertEquals(TEST_STRING_2, element1);
        assertEquals(TEST_STRING_1, element2);
    }
}