package org.coursera.simonenko.sort;

public class InsertionSortTest extends SortTest<InsertionSort<Double>> {

    @Override
    protected InsertionSort<Double> createSort() {
        return new InsertionSort<>();
    }
}
