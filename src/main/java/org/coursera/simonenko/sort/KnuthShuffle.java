package org.coursera.simonenko.sort;

import edu.princeton.cs.algs4.StdRandom;

public class KnuthShuffle<E> implements Shuffle<E> {

    public void shuffle(E[] array) {
        int size = array.length;
        for (int i = 0; i < size; ++i) {
            int randomIndex = StdRandom.uniform(i + 1);
            exchange(array, i, randomIndex);
        }
    }
}
