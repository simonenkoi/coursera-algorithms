package org.coursera.simonenko.sort;

public class MergeSortTest extends SortTest<MergeSort<Double>> {

    @Override
    protected MergeSort<Double> createSort() {
        return new MergeSort<>();
    }
}
