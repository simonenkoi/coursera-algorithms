package org.coursera.simonenko.sort.homework;

/**
 * Merging with smaller auxiliary array. Suppose that the subarray a[0] to a[n−1] is sorted and the subarray a[n] to
 * a[2∗n−1] is sorted. How can you merge the two subarrays so that a[0] to a[2∗n−1] is sorted using an auxiliary array
 * of length n (instead of 2n)?
 */
public class MergeWithSmallerAuxiliary<E extends Comparable<E>> {

    public void merge(E[] array) {
        int arraySize = array.length;
        int auxiliarySize = arraySize / 2;
        E[] auxiliary = (E[]) new Comparable[auxiliarySize];
        System.arraycopy(array, 0, auxiliary, 0, auxiliarySize);

        int i = 0, j = auxiliarySize, k = 0;
        while (k < arraySize) {
            if (j >= arraySize || (i < auxiliarySize && auxiliary[i].compareTo(array[j]) < 0)) {
                array[k] = auxiliary[i];
                ++i;
            } else {
                array[k] = array[j];
                ++j;
            }
            ++k;
        }
    }
}
