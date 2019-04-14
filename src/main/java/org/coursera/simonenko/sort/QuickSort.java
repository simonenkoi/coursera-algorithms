package org.coursera.simonenko.sort;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort<E extends Comparable<E>> implements Sort<E> {

    @Override
    public void sort(E[] array) {
        StdRandom.shuffle(array);
        sort(array, 0, array.length - 1);
    }

    private void sort(E[] array, int low, int high) {
        if (high <= low) {
            return;
        }

        int j = partition(array, low, high);

        sort(array, low, j - 1);
        sort(array, j + 1, high);
    }

    private int partition(E[] a, int low, int high) {
        int i = low + 1;
        int j = high;
        while (true) {
            while (a[i].compareTo(a[low]) < 0 && i != high) {
                ++i;
            }

            while (a[low].compareTo(a[j]) < 0 && j != low) {
                --j;
            }

            if (i < j) {
                exchange(a, i, j);
            } else {
                break;
            }
        }

        exchange(a, low, j);
        return j;
    }
}
