package org.coursera.simonenko.sort.homework.colinearpoints;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    @Override
    public int compareTo(Point that) {
        if (this.y == that.y && this.x == that.y) {
            return 0;
        }
        if (this.y < that.y || (this.y == that.y && this.x < that.x)) {
            return -1;
        }
        return 1;
    }

    public double slopeTo(Point that) {
        if (that.x == this.x && that.y == this.y) {
            return Double.NEGATIVE_INFINITY;
        } else if (that.x == this.x) {
            return Double.POSITIVE_INFINITY;
        } else if (that.y == this.y) {
            return 0.0;
        }
        return (double) (that.y - this.y) / (that.x - this.x);
    }

    public Comparator<Point> slopeOrder() {
        return new SlopeOrderComparator();
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    private class SlopeOrderComparator implements Comparator<Point> {

        private final Point outer = Point.this;

        @Override
        public int compare(Point p1, Point p2) {
            if (outer.slopeTo(p1) < outer.slopeTo(p2)) {
                return -1;
            } else if (outer.slopeTo(p1) > outer.slopeTo(p2)) {
                return 1;
            }
            return 0;
        }
    }
}
