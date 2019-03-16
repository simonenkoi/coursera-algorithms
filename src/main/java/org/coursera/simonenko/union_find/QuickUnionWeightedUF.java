package org.coursera.simonenko.union_find;

public class QuickUnionWeightedUF extends QuickUnionUF {

    protected final int[] weights;

    public QuickUnionWeightedUF(int size) {
        super(size);
        weights = new int[size];
        for (int i = 0; i < size; ++i) {
            weights[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        assertThatParametersAreCorrect(p, q);
        int rootOfP = getRootOfNode(p);
        int rootOfQ = getRootOfNode(q);
        if (rootOfP == rootOfQ) {
            return;
        }
        if (weights[rootOfP] < weights[rootOfQ]) {
            ids[rootOfP] = rootOfQ;
            weights[rootOfQ] += weights[rootOfP];
        } else {
            ids[rootOfQ] = rootOfP;
            weights[rootOfP] += weights[rootOfQ];
        }
    }
}
