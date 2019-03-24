package org.coursera.simonenko.sort;

public interface Sort<E extends Comparable<E>> {

    void sort(E[] array);

    default void exchange(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
