package org.coursera.simonenko.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class StackTest<T extends Stack<String>> {

    protected static final String TEST_STRING_1 = "TEST_STRING_1";
    protected static final String TEST_STRING_2 = "TEST_STRING_2";

    protected T stack;

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
    public void elementPeekedFromEmptyStackShouldBeNull() {
        String actual = stack.peek();

        assertNull(actual);
    }

    @Test
    public void elementPoppedFromEmptyStackShouldBeNull() {
        String actual = stack.pop();

        assertNull(actual);
    }

    @Test
    public void stackShouldNotBeEmptyAfterPushAndPeek() {
        stack.push(TEST_STRING_1);
        stack.peek();
        boolean empty = stack.isEmpty();

        assertFalse(empty);
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