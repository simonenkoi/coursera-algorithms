package org.coursera.simonenko.sort;

public class ShellSort<E extends Comparable<E>> implements Sort<E> {

    public void sort(E[] array) {
        int size = array.length;
        int h = getInitialH(size);
        while (h >= 1) {
            for (int i = h; i < size; ++i) {
                for (int j = i; j >= h && array[j].compareTo(array[j - h]) < 0; j -= h) {
                    exchange(array, j, j - h);
                }
            }

            h /= 3;
        }
    }

    private static int getInitialH(int size) {
        int h = 1;
        while (h < size / 3) {
            h = 3 * h + 1;
        }
        return h;
    }
}
