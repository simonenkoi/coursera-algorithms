package org.coursera.simonenko.sort;

public class ForkJoinMergeSortTest extends SortTest<ForkJoinMergeSort<Double>> {

    @Override
    protected ForkJoinMergeSort<Double> createSort() {
        return new ForkJoinMergeSort<>();
    }
}
