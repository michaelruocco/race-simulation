package uk.co.mruoc.race.gui;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class TrackPoint {

    private final AngledPoint point;
    private final Color color;
    private final double rotation;
    private final Stroke stroke = new BasicStroke(1);
    private final Shape shape;

    public TrackPoint(AngledPoint point, int size, Color color) {
        this.point = point;
        this.color = color;
        this.shape = new Ellipse2D.Float(point.x, point.y, size, size);
        this.rotation = Math.toRadians(point.getAngle());
    }

    public int getX() {
        return point.x;
    }

    public int getY() {
        return point.y;
    }

    public double getRotation() {
        return rotation;
    }

    public void paint(Graphics2D g) {
        g.setStroke(stroke);
        g.setColor(color);
        g.fill(shape);
    }

}
