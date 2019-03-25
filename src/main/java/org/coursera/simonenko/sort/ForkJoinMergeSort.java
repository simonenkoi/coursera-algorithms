package org.coursera.simonenko.sort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ForkJoinMergeSort<E extends Comparable<E>> implements Sort<E> {

    private final ForkJoinPool pool = ForkJoinPool.commonPool();

    @Override
    public void sort(E[] array) {
        ForkJoinTask<Void> job = pool.submit(new MergeSortTask(array, 0, array.length));
        job.join();
    }

    private static class MergeSortTask<E extends Comparable<E>> extends RecursiveAction {

        private final E[] array;
        private final int low;
        private final int high;
        private static final int THRESHOLD = 8;

        private MergeSortTask(E[] array, int low, int high) {
            this.array = array;
            this.low = low;
            this.high = high;
        }

        @Override
        protected void compute() {
            if (high - low <= THRESHOLD) {
                Arrays.sort(array, low, high);
            } else {
                int middle = low + (high - low) / 2;

                invokeAll(new MergeSortTask(array, low, middle), new MergeSortTask(array, middle, high));

                merge(middle);
            }
        }

        protected void merge(int middle) {
            if (array[middle - 1].compareTo(array[middle]) <= 0) {
                return;
            }
            E[] copy = (E[]) new Comparable[high - low];
            System.arraycopy(array, low, copy, 0, copy.length);
            int copyLow = 0;
            int copyMiddle = middle - low;
            int copyHigh = high - low;

            for (int i = low, p = copyLow, q = copyMiddle; i < high; i++) {
                if (q >= copyHigh || (p < copyMiddle && copy[p].compareTo(copy[q]) < 0)) {
                    array[i] = copy[p];
                    p++;
                } else {
                    array[i] = copy[q];
                    q++;
                }
            }
        }
    }

}
