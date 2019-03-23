package org.coursera.simonenko.stack;

/**
 * Stack with max. Create a data structure that efficiently supports the stack operations (push and pop) and also a
 * return-the-maximum operation. Assume the elements are real numbers so that you can compare them.
 */
public class StackWithMax<E extends Comparable<E>> implements Stack<E> {

    private Stack<E> stack;
    private Stack<E> maxElements;

    public StackWithMax() {
        stack = new ResizingStack<>();
        maxElements = new ResizingStack<>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(E item) {
        stack.push(item);
        if (stack.isEmpty()) {
            maxElements.push(item);
        } else {
            E currentMax = maxElements.peek();
            if (currentMax == null || item.compareTo(currentMax) > 0) {
                maxElements.push(item);
            }
        }
    }

    public E peek() {
        return stack.peek();
    }

    public E pop() {
        E item = stack.pop();
        E currentMaxElement = maxElements.peek();
        if (currentMaxElement != null && item.compareTo(currentMaxElement) == 0) {
            maxElements.pop();
        }
        return item;
    }

    public E getMaxElement() {
        return maxElements.peek();
    }
}
