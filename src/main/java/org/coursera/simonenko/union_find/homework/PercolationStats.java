package org.coursera.simonenko.union_find.homework;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final double[] results;
    private final int numberOfExperiments;

    public PercolationStats(int gridSideSize, int numberOfExperiments) {
        if (gridSideSize <= 0 || numberOfExperiments <= 0) {
            throw new IllegalArgumentException();
        }

        this.numberOfExperiments = numberOfExperiments;
        double gridSize = gridSideSize * gridSideSize;
        results = new double[numberOfExperiments];
        Percolation percolation;
        for (int k = 0; k < numberOfExperiments; ++k) {
            percolation = new Percolation(gridSideSize);

            int i;
            int j;
            int openNum = 0;
            while (!percolation.percolates()) {
                i = StdRandom.uniform(1, gridSideSize + 1);
                j = StdRandom.uniform(1, gridSideSize + 1);
                if (percolation.isOpen(i, j))
                    continue;
                percolation.open(i, j);
                openNum++;
            }

            results[k] = openNum / gridSize;
        }
    }

    public double mean() {
        return StdStats.mean(results);
    }

    public double stddev() {
        return StdStats.stddev(results);
    }

    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(numberOfExperiments);
    }

    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(numberOfExperiments);
    }

    public static void main(String[] args) {
        int gridSideSize = Integer.parseInt(args[0]);
        int numberOfExperiments = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(gridSideSize, numberOfExperiments);
        StdOut.printf("mean                    = %f%n", ps.mean());
        StdOut.printf("stddev                  = %f%n", ps.stddev());
        StdOut.printf("95%% confidence interval = %f, %f%n", ps.confidenceLo(), ps.confidenceHi());
    }
}