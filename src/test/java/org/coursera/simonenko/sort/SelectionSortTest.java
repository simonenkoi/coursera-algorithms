package org.coursera.simonenko.sort;

public class SelectionSortTest extends SortTest<SelectionSort<Double>> {

    @Override
    protected SelectionSort<Double> createSort() {
        return new SelectionSort<>();
    }
}
