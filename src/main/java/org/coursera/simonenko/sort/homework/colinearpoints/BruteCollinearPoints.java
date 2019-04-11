package org.coursera.simonenko.sort.homework.colinearpoints;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Arrays;

public class BruteCollinearPoints {

    private final Point[] points;
    private LineSegment[] segments;
    private int segmentsCount;

    public BruteCollinearPoints(Point[] points) {
        validatePoints(points);

        this.points = points.clone();
        this.segments = new LineSegment[2];
        this.segmentsCount = 0;

        Arrays.sort(this.points);

        int length = this.points.length;
        for (int i = 0; i < length - 3; i++) {
            for (int j = i + 1; j < length - 2; j++) {
                for (int k = j + 1; k < length - 1; k++) {
                    for (int l = k + 1; l < length; l++) {
                        if (this.points[i].slopeTo(this.points[j]) == this.points[j].slopeTo(this.points[k]) &&
                                this.points[j].slopeTo(this.points[k]) == this.points[k].slopeTo(this.points[l])) {

                            enqueue(new LineSegment(this.points[i], this.points[l]));

                            this.points[i].drawTo(this.points[l]);
                            StdDraw.show();
                        }
                    }
                }
            }
        }
    }

    private void resize(int capacity) {
        LineSegment[] temp = new LineSegment[capacity];
        System.arraycopy(segments, 0, temp, 0, segmentsCount);
        segments = temp;
    }

    private void enqueue(LineSegment item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (segmentsCount == segments.length) {
            resize(2 * segments.length);
        }

        segments[segmentsCount] = item;
        ++segmentsCount;
    }

    private void validatePoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {

                if (points[i] == null || points[j] == null) {
                    throw new IllegalArgumentException();
                }

                if (i != j && points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public int numberOfSegments() {
        return segmentsCount;
    }

    public LineSegment[] segments() {
        return Arrays.copyOf(segments, segmentsCount);
    }

}
