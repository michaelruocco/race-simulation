package uk.co.mruoc.race.gui;

import java.awt.*;

public class AngledPoint extends Point {

    private final int angle;

    public AngledPoint(int x, int y, int angle) {
        super(x, y);
        this.angle = angle;
    }

    public int getAngle() {
        return angle;
    }

}
