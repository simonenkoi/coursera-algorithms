package org.coursera.simonenko.sort.homework;

import org.coursera.simonenko.sort.SortTest;
import org.junit.Before;
import org.junit.Test;

public class MergeWithSmallerAuxiliaryTest {

    private MergeWithSmallerAuxiliary<Integer> mergeWithSmallerAuxiliary;

    @Before
    public void init() {
        mergeWithSmallerAuxiliary = new MergeWithSmallerAuxiliary<>();
    }

    @Test
    public void arrayShouldBeSortedAfterMerge() {
        Integer[] array = {40, 61, 70, 71, 99, 20, 51, 55, 75, 100};
        mergeWithSmallerAuxiliary.merge(array);

        SortTest.assertArraySorted(array);
    }

}