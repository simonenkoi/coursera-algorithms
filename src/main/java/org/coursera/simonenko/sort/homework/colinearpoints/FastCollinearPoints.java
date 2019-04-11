package org.coursera.simonenko.sort.homework.colinearpoints;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Arrays;
import java.util.LinkedList;

public class FastCollinearPoints {

    private final Point[] points;
    private LineSegment[] segments;
    private int segmentsCount;

    public FastCollinearPoints(Point[] points) {
        validatePoints(points);

        this.points = points.clone();
        this.segments = new LineSegment[2];
        this.segmentsCount = 0;
        LinkedList<Point> collinearPoints = new LinkedList<>();

        for (Point point : this.points) {
            Arrays.sort(this.points, point.slopeOrder());
            double prevSlope = 0.0;

            for (int j = 0; j < this.points.length; j++) {
                double currentSlope = point.slopeTo(this.points[j]);
                if (j == 0 || currentSlope != prevSlope) {

                    if (collinearPoints.size() >= 3) {
                        enqueue(new LineSegment(collinearPoints.getFirst(), collinearPoints.getLast()));
                        collinearPoints.getFirst().drawTo(collinearPoints.getLast());
                        StdDraw.show();
                    }

                    collinearPoints.clear();
                }

                collinearPoints.add(this.points[j]);
                prevSlope = currentSlope;
            }
        }

    }

    public int numberOfSegments() {
        return segmentsCount;
    }

    public LineSegment[] segments() {
        return Arrays.copyOf(segments, segmentsCount);
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
}