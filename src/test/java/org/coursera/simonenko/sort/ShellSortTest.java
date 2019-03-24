package org.coursera.simonenko.sort;

public class ShellSortTest extends SortTest<ShellSort<Double>> {

    @Override
    protected ShellSort<Double> createSort() {
        return new ShellSort<>();
    }
}
