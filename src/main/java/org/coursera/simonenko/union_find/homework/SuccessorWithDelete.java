package org.coursera.simonenko.union_find.homework;

/**
 * Given a set of nn integers S = \{ 0, 1, ... , n-1 \}S={0,1,...,n−1} and a sequence of requests of the following
 * form:
 * <p>
 * Remove xx from SS
 * Find the successor of xx: the smallest yy in SS such that y \ge xy≥x.
 * design a data type so that all operations (except construction) take logarithmic time or better in the worst case.
 */
public class SuccessorWithDelete {

    private final int size;
    private final boolean[] elementsInSet;
    private final SpecificCanonicalElement uf;

    public SuccessorWithDelete(int size) {
        this.size = size;
        elementsInSet = new boolean[size];
        for (int i = 0; i < size; ++i) {
            elementsInSet[i] = true;
        }
        uf = new SpecificCanonicalElement(size);
    }

    public void remove(int x) {
        elementsInSet[x] = false;
        if (x > 0 && !elementsInSet[x - 1])
            uf.union(x, x - 1);
        if (x < size - 1 && !elementsInSet[x + 1])
            uf.union(x, x + 1);
    }

    public int successor(int x) {
        if (elementsInSet[x]) {
            return x;
        } else {
            int res = uf.find(x) + 1;
            if (res >= size) {
                return -1;
            } else {
                return res;
            }
        }
    }
}
