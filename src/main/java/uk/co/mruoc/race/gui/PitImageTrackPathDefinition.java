package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.gui.Corner.CornerBuilder;
import uk.co.mruoc.race.gui.Straight.StraightBuilder;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class PitImageTrackPathDefinition extends TrackPathDefinition {

    private static final Checkpoint checkpoint4 = new Checkpoint(4, new Point(860, 260));
    private static final Checkpoint checkpoint5 = new Checkpoint(5, new Point(860, 365));

    private static final Corner corner1 = new CornerBuilder()
            .setStart(new Point(770, 220))
            .setControl1(new Point(770, 240))
            .setControl2(new Point(770, 240))
            .setEnd(new Point(830, 240))
            .setStartAngle(360)
            .setEndAngle(270)
            .build();

    private static final Corner corner2 = new CornerBuilder()
            .setStart(new Point(830, 240))
            .setControl1(new Point(890, 250))
            .setControl2(new Point(890, 280))
            .setEnd(new Point(890, 280))
            .setCheckpoints(checkpoint4)
            .setStartAngle(270)
            .setEndAngle(360)
            .build();

    private static final Straight straight1 = new StraightBuilder()
            .setStart(new Point(890, 280))
            .setEnd(new Point(890, 330))
            .setAngle(0)
            .build();

    private static final Corner corner3 = new CornerBuilder()
            .setStart(new Point(890, 330))
            .setControl1(new Point(890, 340))
            .setControl2(new Point(890, 370))
            .setEnd(new Point(830, 370))
            .setCheckpoints(checkpoint5)
            .setStartAngle(0)
            .setEndAngle(90)
            .build();

    private static final Straight straight2 = new StraightBuilder()
            .setStart(new Point(830, 370))
            .setEnd(new Point(660, 404))
            .setAngle(90)
            .build();

    private static final List<TrackPart> parts = Arrays.asList(
            corner1,
            corner2,
            straight1,
            corner3,
            straight2
    );

    public PitImageTrackPathDefinition() {
        super(3, parts);
    }

}
