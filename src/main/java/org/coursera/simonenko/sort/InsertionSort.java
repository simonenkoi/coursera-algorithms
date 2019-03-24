package org.coursera.simonenko.sort;

public class InsertionSort<E extends Comparable<E>> implements Sort<E> {

    public void sort(E[] array) {
        int size = array.length;
        for (int i = 0; i < size; ++i) {
            for (int j = i; j > 0; --j) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    exchange(array, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
