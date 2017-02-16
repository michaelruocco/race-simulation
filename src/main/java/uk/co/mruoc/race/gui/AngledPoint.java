package uk.co.mruoc.race.gui;

import java.awt.*;

public class AngledPoint extends Point {

    private final double angle;

    public AngledPoint(int x, int y, double angle) {
        super(x, y);
        this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }

}
