package uk.co.mruoc.race.gui;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class TrackPoint {

    private final Point point;
    private final int size;
    private final Color color;

    public TrackPoint(Point point, int size, Color color) {
        this.point = point;
        this.size = size;
        this.color = color;
    }

    public int getX() {
        return point.x;
    }

    public int getY() {
        return point.y;
    }

    public void paint(Graphics2D g) {
        g.setStroke(new BasicStroke(1));
        g.setColor(color);
        g.fill(shape());
    }

    private Shape shape() {
        return new Ellipse2D.Float(point.x, point.y, size, size);
    }

}
