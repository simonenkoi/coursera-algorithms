package org.coursera.simonenko.sort.homework.colinearpoints;

public class LineSegment {

    public final Point p;
    public final Point q;

    public LineSegment(Point p, Point q) {
        this.p = p;
        this.q = q;
    }

    public void draw() {
        p.drawTo(q);
    }

    public String toString() {
        return p + " -> " + q;
    }

}
