package org.coursera.simonenko.union_find;

public class QuickFindUF implements UF {

    private final int[] ids;

    public QuickFindUF(int size) {
        ids = new int[size];
        for (int i = 0; i < size; ++i) {
            ids[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        assertThatParametersAreCorrect(p, q);
        return ids[p] == ids[q];
    }

    public void union(int p, int q) {
        assertThatParametersAreCorrect(p, q);
        int pId = ids[p];
        int qId = ids[q];
        for (int i = 0; i < ids.length; ++i) {
            if (ids[i] == pId) {
                ids[i] = qId;
            }
        }
    }

    private void assertThatParametersAreCorrect(int p, int q) {
        if (p >= ids.length || q >= ids.length) {
            throw new IllegalArgumentException();
        }
    }
}
