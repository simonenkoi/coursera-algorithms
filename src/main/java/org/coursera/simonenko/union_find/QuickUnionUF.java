package org.coursera.simonenko.union_find;

public class QuickUnionUF implements UF {

    private final int[] ids;

    public QuickUnionUF(int size) {
        ids = new int[size];
        for (int i = 0; i < size; ++i) {
            ids[i] = i;
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
        ids[rootOfP] = rootOfQ;
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
