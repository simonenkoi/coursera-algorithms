package org.coursera.simonenko.union_find.homework;

/**
 * Given a social network containing nn members and a log file containing mm timestamps at which times pairs of
 * members formed friendships, design an algorithm to determine the earliest time at which all members are connected
 * (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted by
 * timestamp and that friendship is an equivalence relation. The running time of your algorithm should be m \log nmlogn
 * or better and use extra space proportional to nn.
 */
public class SocialNetworkConnectivity {

    private final int[] ids;
    private final int[] weights;
    private int componentsCount;

    public SocialNetworkConnectivity(int size) {
        componentsCount = size;
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
        --componentsCount;
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
