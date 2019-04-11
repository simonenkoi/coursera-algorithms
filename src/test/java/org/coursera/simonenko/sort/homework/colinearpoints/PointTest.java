package org.coursera.simonenko.sort.homework.colinearpoints;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    private static final Point p = new Point(4, 4);
    private static final Point p1 = new Point(5, 5);
    private static final Point p2 = new Point(4, 5);
    private static final Point p3 = new Point(3, 4);

    @Test
    public void test1() {
        assertEquals(-1, p.compareTo(p1));
        assertEquals(0, p1.compareTo(p1));
        assertEquals(1, p1.compareTo(p));
    }

    @Test
    public void slopeTest() {
        assertEquals(Double.POSITIVE_INFINITY, p.slopeTo(p2));
        assertEquals(0.0, p.slopeTo(p3));
        assertEquals(Double.NEGATIVE_INFINITY, p.slopeTo(p));
        assertEquals(1.0, p.slopeTo(p1));

    }

    @Test
    public void slopeOrderTest() {
        assertEquals(1, p.slopeOrder().compare(p2, p3));
        assertEquals(1, p1.slopeOrder().compare(p, p3));
        assertEquals(-1, p1.slopeOrder().compare(p3, p));
        assertEquals(0, p1.slopeOrder().compare(p3, p3));
    }
}