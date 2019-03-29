package org.coursera.simonenko.sort;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Before;
import org.junit.Test;

public abstract class SortTest<T extends Sort<Double>> {

    private static final int SIZE = 10_000;
    protected T sort;

    protected abstract T createSort();

    @Before
    public void setUp() {
        sort = createSort();
    }

    @Test
    public void ascendingArrayMustBeSorted() {
        Double[] array = new Double[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            array[i] = (double) i;
        }

        sort.sort(array);

        assertArraySorted(array);
    }

    @Test
    public void randomArrayMustBeSorted() {
        Double[] array = new Double[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            array[i] = (double) (SIZE - i);
        }

        sort.sort(array);

        assertArraySorted(array);
    }

    @Test
    public void descendingArrayMustBeSorted() {
        Double[] array = new Double[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            array[i] = StdRandom.uniform();
        }

        sort.sort(array);

        assertArraySorted(array);
    }

    public static <E extends Comparable<E>> void assertArraySorted(E[] array) {
        int arraySize = array.length;
        for (int i = 1; i < arraySize; ++i) {
            if (array[i - 1].compareTo(array[i]) > 0) {
                throw new AssertionError();
            }
        }

    }
}