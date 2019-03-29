package org.coursera.simonenko.sort.homework;

import java.util.Arrays;

/**
 * Intersection of two sets. Given two arrays a[] and b[], each containing nnn distinct 2D points in the plane, design a
 * subquadratic algorithm to count the number of points that are contained both in array a[] and array b[].
 */
public class IntersectionOfTwoSets {

    private IntersectionOfTwoSets() {
    }

    private static class Point implements Comparable<Point> {

        private final Double x;
        private final Double y;

        private Point(Double x, Double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object p) {
            if (p == null) {
                return false;
            }
            if (!(p instanceof Point)) {
                return false;
            }
            Point obj = (Point) p;
            return (obj.x == this.x && obj.y == this.y);
        }

        @Override
        public int compareTo(Point o) {
            int diff = this.x.compareTo(o.x);
            return diff != 0 ? diff : this.y.compareTo(o.y);
        }
    }

    public static long intersections(Point[] first, Point[] second) {
        Arrays.sort(first);
        Arrays.sort(second);

        return Arrays.stream(first)
                     .mapToInt(point -> Arrays.binarySearch(second, point))
                     .filter(i1 -> i1 > 0)
                     .count();
    }
}
