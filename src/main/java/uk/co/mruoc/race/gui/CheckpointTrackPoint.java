package uk.co.mruoc.race.gui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

import static java.awt.Color.ORANGE;

public class CheckpointTrackPoint extends TrackPoint {

    private static final Logger LOG = LogManager.getLogger(CheckpointTrackPoint.class);

    private static final int SIZE = 3;
    private static final Color COLOR = ORANGE;

    private int id;

    public CheckpointTrackPoint(AngledPoint point, int id) {
        super(point, SIZE, COLOR);
        this.id = id;
        LOG.debug("checkpoint " + id + " created at x " + point.x + " y " + point.y + " angle " + point.getAngle());
    }

    public int getId() {
        return id;
    }

}
