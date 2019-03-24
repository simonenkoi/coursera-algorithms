package org.coursera.simonenko.sort;

public class SelectionSort<E extends Comparable<E>> implements Sort<E> {

    public void sort(E[] array) {
        int size = array.length;
        for (int i = 0; i < size; ++i) {
            int indexOfSmallest = i;
             for (int j = i + 1; j < size; ++j) {
                 if (array[j].compareTo( array[indexOfSmallest]) < 0) {
                     indexOfSmallest = j;
                 }
             }
             exchange(array, i, indexOfSmallest);
        }
    }
}
