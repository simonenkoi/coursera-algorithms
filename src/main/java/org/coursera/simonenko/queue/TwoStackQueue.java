package org.coursera.simonenko.queue;

import org.coursera.simonenko.stack.ResizingStack;
import org.coursera.simonenko.stack.Stack;

/**
 * Queue with two stacks. Implement a queue with two stacks so that each queue operations takes a constant amortized
 * number of stack operations.
 */
public class TwoStackQueue<E> implements Queue<E> {
    private Stack<E> stackOne;
    private Stack<E> stackTwo;

    public TwoStackQueue() {
        stackOne = new ResizingStack<>();
        stackTwo = new ResizingStack<>();
    }

    public boolean isEmpty() {
        return stackOne.isEmpty() && stackTwo.isEmpty();
    }

    public void queue(E item) {
        stackOne.push(item);
    }

    public E dequeue() {
        if (stackTwo.isEmpty()) {
            moveAllItemsFromStackOneToStackTwo();
        }
        return stackTwo.pop();
    }

    private void moveAllItemsFromStackOneToStackTwo() {
        while (!stackOne.isEmpty()) {
            E tmp = stackOne.pop();
            stackTwo.push(tmp);
        }
    }
}
