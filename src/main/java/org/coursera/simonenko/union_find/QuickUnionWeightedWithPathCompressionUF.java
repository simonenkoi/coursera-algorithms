package org.coursera.simonenko.union_find;

public class QuickUnionWeightedWithPathCompressionUF extends QuickUnionWeightedUF {

    public QuickUnionWeightedWithPathCompressionUF(int size) {
        super(size);
    }

    @Override
    protected int getRootOfNode(int node) {
        while (node != ids[node]) {
            ids[node] = ids[ids[node]];
            node = ids[node];
        }
        return node;
    }

}
