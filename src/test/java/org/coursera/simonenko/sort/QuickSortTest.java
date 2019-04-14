package org.coursera.simonenko.sort;

public class QuickSortTest extends SortTest<QuickSort<Double>> {

    @Override
    protected QuickSort<Double> createSort() {
        return new QuickSort<>();
    }
}
