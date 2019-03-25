package org.coursera.simonenko.sort;

public class MergeSort<E extends Comparable<E>> implements Sort<E> {

    @Override
    public void sort(E[] array) {
        E[] auxiliaryArray = (E[]) new Comparable[array.length];
        sort(array, auxiliaryArray, 0, array.length - 1);
    }

    private void sort(E[] array, E[] auxiliaryArray, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;

        sort(array, auxiliaryArray, low, mid);
        sort(array, auxiliaryArray, mid + 1, high);

        merge(array, auxiliaryArray, low, mid, high);
    }

    private void merge(E[] array, E[] auxiliaryArray, int low, int mid, int high) {
        if (array[mid].compareTo(array[mid + 1]) <= 0) {
            return;
        }

        System.arraycopy(array, low, auxiliaryArray, low, high - low + 1);

        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; ++k) {
            if (i > mid || (j <= high && auxiliaryArray[j].compareTo(auxiliaryArray[i]) < 0)) {
                array[k] = auxiliaryArray[j];
                ++j;
            } else {
                array[k] = auxiliaryArray[i];
                ++i;
            }
        }
    }
}
