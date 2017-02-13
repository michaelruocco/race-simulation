package uk.co.mruoc.race.gui;

import java.awt.*;
import java.awt.geom.Point2D;

public class PointScaler {

    public static Point scale(Point2D point, ScaleParams params) {
        int scaledX = (int)(point.getX() * params.getY());
        int scaledY = (int)(point.getY() * params.getY());
        return new Point(scaledX, scaledY);
    }

}
