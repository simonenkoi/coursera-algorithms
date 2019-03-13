package org.coursera.simonenko.union_find;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class QuickFindUFTest {

    @Parameterized.Parameters
    public static Collection<Class<? extends UF>> data() {
        return Arrays.asList(QuickFindUF.class, QuickUnionUF.class, QuickUnionWeightedUF.class);
    }

    private Class<? extends UF> ufClass;

    public QuickFindUFTest(Class<? extends UF> ufClass) {
        this.ufClass = ufClass;
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionIsThrownIfUnionHasIncorrectFirstParameter() {
        UF uf = instantiateClassOfSize(10);

        uf.union(10, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionIsThrownIfUnionHasIncorrectSecondParameter() {
        UF uf = instantiateClassOfSize(10);

        uf.union(3, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionIsThrownIfConnectedHasIncorrectFirstParameter() {
        UF uf = instantiateClassOfSize(10);

        uf.connected(10, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionIsThrownIfConnectedHasIncorrectSecondParameter() {
        UF uf = instantiateClassOfSize(10);

        uf.connected(3, 10);
    }

    @Test
    public void pairOfNodesWillBeConnectedAfterUnion() {
        UF uf = instantiateClassOfSize(10);

        uf.union(4, 3);
        uf.union(3, 8);

        assertTrue(uf.connected(3, 4));
        assertTrue(uf.connected(4, 3));

        assertTrue(uf.connected(3, 8));
        assertTrue(uf.connected(8, 3));

        assertTrue(uf.connected(4, 8));
        assertTrue(uf.connected(8, 4));
    }

    @Test
    public void nodesWillBeInTheDifferentComponentsAfterUnion() {
        UF uf = instantiateClassOfSize(10);

        uf.union(4, 3);
        uf.union(6, 5);

        assertTrue(uf.connected(5, 6));
        assertTrue(uf.connected(6, 5));

        assertFalse(uf.connected(4, 6));
        assertFalse(uf.connected(6, 4));

        assertFalse(uf.connected(4, 5));
        assertFalse(uf.connected(5, 4));

        assertFalse(uf.connected(3, 6));
        assertFalse(uf.connected(6, 3));

        assertFalse(uf.connected(3, 5));
        assertFalse(uf.connected(5, 3));
    }

    private UF instantiateClassOfSize(int size) {
        try {
            Constructor<? extends UF> constructor = ufClass.getConstructor(int.class);
            return constructor.newInstance(size);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}