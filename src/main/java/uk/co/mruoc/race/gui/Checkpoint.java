package uk.co.mruoc.race.gui;

import java.awt.*;
import java.util.List;

public class Checkpoint implements Scalable<Checkpoint> {

    private final int id;
    private final Point location;

    public Checkpoint(int id, Point location) {
        this.id = id;
        this.location = location;
    }

    public int calculateIndex(List<Point> points) {
        int index = points.indexOf(location);
        if (index == -1)
            index = nearestIndex(points);
        return Math.min(index, points.size() - 1);
    }

    private int nearestIndex(List<Point> points) {
        int minDiff = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            int diffX = Math.abs(point.x - location.x);
            int diffY = Math.abs(point.y - location.y);
            int diff = diffX + diffY;
            if (diff < minDiff) {
                minDiff = diff;
                index = i;
            }
        }
        return index;
    }

    public int getId() {
        return id;
    }

    public Checkpoint scale(ScaleParams params) {
        Point scaledLocation = PointScaler.scale(location, params);
        return new Checkpoint(id, scaledLocation);
    }

}
