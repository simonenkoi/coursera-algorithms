package org.coursera.simonenko.union_find.homework;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final boolean[][] opened;
    private final int top;
    private final int bottom;
    private final int size;
    private final WeightedQuickUnionUF qf;

    private int numberOfOpenSites = 0;

    public Percolation(int size) {
        this.size = size;
        top = 0;
        bottom = this.size * this.size + 1;
        qf = new WeightedQuickUnionUF(this.size * this.size + 2);
        opened = new boolean[this.size][this.size];
    }

    public void open(int i, int j) {
        assertThatParametersAreCorrect(i, j);
        opened[i - 1][j - 1] = true;
        if (i == 1) {
            qf.union(getQFIndex(i, j), top);
        }
        if (i == size) {
            qf.union(getQFIndex(i, j), bottom);
        }

        if (j > 1 && isOpen(i, j - 1)) {
            qf.union(getQFIndex(i, j), getQFIndex(i, j - 1));
        }
        if (j < size && isOpen(i, j + 1)) {
            qf.union(getQFIndex(i, j), getQFIndex(i, j + 1));
        }
        if (i > 1 && isOpen(i - 1, j)) {
            qf.union(getQFIndex(i, j), getQFIndex(i - 1, j));
        }
        if (i < size && isOpen(i + 1, j)) {
            qf.union(getQFIndex(i, j), getQFIndex(i + 1, j));
        }
        ++numberOfOpenSites;
    }

    public boolean isOpen(int i, int j) {
        assertThatParametersAreCorrect(i, j);
        return opened[i - 1][j - 1];
    }

    public boolean isFull(int i, int j) {
        assertThatParametersAreCorrect(i, j);
        return qf.connected(top, getQFIndex(i, j));
    }

    public boolean percolates() {
        return qf.connected(top, bottom);
    }

    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    private int getQFIndex(int i, int j) {
        return size * (i - 1) + j;
    }

    private void assertThatParametersAreCorrect(int i, int j) {
        if (i <= 0 || i > size || j <= 0 || j > size) {
            throw new IllegalArgumentException();
        }
    }
}