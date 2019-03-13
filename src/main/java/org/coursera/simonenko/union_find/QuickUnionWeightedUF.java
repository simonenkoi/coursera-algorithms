package org.coursera.simonenko.union_find;

public class QuickUnionWeightedUF implements UF {

    private final int[] ids;
    private final int[] weights;

    public QuickUnionWeightedUF(int size) {
        ids = new int[size];
        weights = new int[size];
        for (int i = 0; i < size; ++i) {
            ids[i] = i;
            weights[i] = 1;
        }
    }

    public boolean connected(int p, int q) {
        assertThatParametersAreCorrect(p, q);
        return getRootOfNode(p) == getRootOfNode(q);
    }

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

    private int getRootOfNode(int node) {
        while (node != ids[node]) {
            node = ids[node];
        }
        return node;
    }

    private void assertThatParametersAreCorrect(int p, int q) {
        if (p >= ids.length || q >= ids.length) {
            throw new IllegalArgumentException();
        }
    }
}
