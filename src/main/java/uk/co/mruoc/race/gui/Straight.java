package uk.co.mruoc.race.gui;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static uk.co.mruoc.race.gui.TrackPointsBuilder.toTrackPoints;

public class Straight implements TrackPart {

    private final List<TrackPoint> trackPoints;
    private final Line2D line;

    private Straight(StraightBuilder builder) {
        line = builder.getLine();
        List<Checkpoint> checkpoints = builder.checkpoints;
        List<Point> points = toPoints(line);
        trackPoints = toTrackPoints(points, checkpoints);
    }

    @Override
    public List<TrackPoint> getPoints() {
        return trackPoints;
    }

    @Override
    public void moveToStart(GeneralPath path) {
        path.moveTo(line.getX1(), line.getY1());
    }

    @Override
    public void appendTo(GeneralPath path) {
        path.append(line, true);
    }

    private List<Point> toPoints(Line2D line) {
        Point2D start = line.getP1();
        Point2D end = line.getP2();
        Point[][] grid = buildGrid(start, end);

        int x0 = (int) start.getX();
        int y0 = (int) start.getY();

        int x1 = (int) end.getX();
        int y1 = (int) end.getY();

        List<Point> points = new ArrayList<>();

        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);

        int sx = x0 < x1 ? 1 : -1;
        int sy = y0 < y1 ? 1 : -1;

        int err = dx-dy;
        int e2;

        while (true) {
            points.add(grid[x0][y0]);

            if (x0 == x1 && y0 == y1)
                break;

            e2 = 2 * err;
            if (e2 > -dy) {
                err = err - dy;
                x0 = x0 + sx;
            }

            if (e2 < dx) {
                err = err + dx;
                y0 = y0 + sy;
            }
        }

        return points;
    }

    private static Point[][] buildGrid(Point2D start, Point2D end) {
        int rows = (int) Math.max(start.getX(), end.getX()) + 1;
        int cols = (int) Math.max(start.getY(), end.getY()) + 1;

        Point[][] grid = new Point[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                grid[i][j] = new Point(i, j);

        return grid;
    }

    public static class StraightBuilder {

        private Point start;
        private Point end;
        private List<Checkpoint> checkpoints = Collections.emptyList();

        public StraightBuilder setStart(Point start) {
            this.start = start;
            return this;
        }

        public StraightBuilder setEnd(Point end) {
            this.end = end;
            return this;
        }

        public StraightBuilder setCheckpoints(Checkpoint... checkpoints) {
            this.checkpoints = Arrays.asList(checkpoints);
            return this;
        }

        public Line2D getLine() {
            return new Line2D.Float(start, end);
        }

        public Straight build() {
            return new Straight(this);
        }

    }

}
