package org.coursera.simonenko.sort.homework;

import java.util.Arrays;

/**
 * Permutation. Given two integer arrays of size nnn, design a subquadratic algorithm to determine whether one is a
 * permutation of the other. That is, do they contain exactly the same entries but, possibly, in a different order.
 */
public class Permutation {

    private Permutation() {
    }

    public static boolean isPermutation(int[] first, int[] second) {
        Arrays.sort(first);
        Arrays.sort(second);

        return Arrays.equals(first, second);
    }
}
