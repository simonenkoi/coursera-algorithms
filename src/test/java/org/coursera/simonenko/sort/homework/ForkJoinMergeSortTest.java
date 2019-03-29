package org.coursera.simonenko.sort.homework;

import org.coursera.simonenko.sort.SortTest;
import org.coursera.simonenko.sort.homework.ForkJoinMergeSort;

public class ForkJoinMergeSortTest extends SortTest<ForkJoinMergeSort<Double>> {

    @Override
    protected ForkJoinMergeSort<Double> createSort() {
        return new ForkJoinMergeSort<>();
    }
}
