package uk.co.mruoc.race.gui;

import java.awt.*;

import static java.awt.Color.BLACK;

public class DefaultTrackPoint extends TrackPoint {

    private static final int SIZE = 1;
    private static final Color COLOR = BLACK;

    public DefaultTrackPoint(AngledPoint point) {
        super(point, SIZE, COLOR);
    }

}
