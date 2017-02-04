package uk.co.mruoc.race.gui;

import java.awt.*;

import static java.awt.Color.RED;

public class CheckpointTrackPoint extends TrackPoint {

    private static final int SIZE = 3;
    private static final Color COLOR = RED;

    private int id;

    public CheckpointTrackPoint(Point point, int id) {
        super(point, SIZE, COLOR);
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
