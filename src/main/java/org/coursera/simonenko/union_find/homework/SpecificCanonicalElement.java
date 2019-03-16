package org.coursera.simonenko.union_find.homework;

/**
 * Add a method \mathtt{find()}find() to the union-find data type so that \mathtt{find(i)}find(i) returns the largest
 * element in the connected component containing ii. The operations, \mathtt{union()}union(), \mathtt{connected()}
 * connected(), and \mathtt{find()}find() should all take logarithmic time or better.
 *
 * For example, if one of the connected components is \{1, 2, 6, 9\}{1,2,6,9}, then the \mathtt{find()}find() method
 * should return 99 for each of the four elements in the connected components.
 */
public class SpecificCanonicalElement {

    private final int[] ids;
    private final int[] weights;
    private final int[] largestElements;

    public SpecificCanonicalElement(int size) {
        ids = new int[size];
        weights = new int[size];
        largestElements = new int[size];
        for (int i = 0; i < size; ++i) {
            ids[i] = i;
            weights[i] = 1;
            largestElements[i] = i;
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
        int largestInPComponent = largestElements[rootOfP];
        int largestInQComponent = largestElements[rootOfQ];
        if (weights[rootOfP] < weights[rootOfQ]) {
            ids[rootOfP] = rootOfQ;
            weights[rootOfQ] += weights[rootOfP];
            if (largestInPComponent > largestInQComponent) {
                largestElements[rootOfQ] = largestInPComponent;
            }
        } else {
            ids[rootOfQ] = rootOfP;
            weights[rootOfP] += weights[rootOfQ];
            if (largestInQComponent > largestInPComponent) {
                largestElements[rootOfP] = largestInQComponent;
            }
        }
    }

    public int find(int p) {
        return largestElements[p];
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
