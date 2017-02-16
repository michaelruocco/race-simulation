package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.gui.Corner.CornerBuilder;
import uk.co.mruoc.race.gui.Straight.StraightBuilder;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class MainImageTrackPathDefinition extends TrackPathDefinition {

    private static final Checkpoint checkpoint1 = new Checkpoint(1, new Point(427, 135));
    private static final Checkpoint checkpoint2 = new Checkpoint(2, new Point(770, 180));
    private static final Checkpoint checkpoint3 = new Checkpoint(3, new Point(770, 218));

    private static final Checkpoint checkpoint6 = new Checkpoint(6, new Point(660, 404));
    private static final Checkpoint checkpoint7 = new Checkpoint(7, new Point(427, 404));
    private static final Checkpoint checkpoint8 = new Checkpoint(8, new Point(76, 322));
    private static final Checkpoint checkpoint9 = new Checkpoint(9, new Point(76, 263));
    private static final Checkpoint checkpoint0 = new Checkpoint(0, new Point(155, 135));

    private static final TrackPart straight1 = new StraightBuilder()
            .setStart(new Point(155, 135))
            .setEnd(new Point(700, 135))
            .setCheckpoints(checkpoint1)
            .setAngle(270)
            .build();

    private static final TrackPart corner1 = new CornerBuilder()
            .setStart(new Point(700, 135))
            .setControl1(new Point(770, 135))
            .setControl2(new Point(770, 175))
            .setEnd(new Point(770, 195))
            .setCheckpoints(checkpoint2)
            .build();

    private static final TrackPart straight2 = new StraightBuilder()
            .setStart(new Point(770, 195))
            .setEnd(new Point(770, 335))
            .setCheckpoints(checkpoint3)
            .setAngle(0)
            .build();

    private static final TrackPart corner2 = new CornerBuilder()
            .setStart(new Point(770, 335))
            .setControl1(new Point(770, 354))
            .setControl2(new Point(770, 404))
            .setEnd(new Point(680, 404))
            .build();

    private static final TrackPart straight3 = new StraightBuilder()
            .setStart(new Point(680, 404))
            .setEnd(new Point(155, 404))
            .setCheckpoints(checkpoint6, checkpoint7)
            .setAngle(90)
            .build();

    private static final TrackPart corner3 = new CornerBuilder()
            .setStart(new Point(155, 404))
            .setControl1(new Point(76, 404))
            .setControl2(new Point(76, 364))
            .setEnd(new Point(76, 364))
            .build();

    private static final TrackPart straight4 = new StraightBuilder()
            .setStart(new Point(76, 364))
            .setEnd(new Point(76, 195))
            .setCheckpoints(checkpoint8, checkpoint9)
            .setAngle(180)
            .build();

    private static final TrackPart corner4 = new CornerBuilder()
            .setStart(new Point(76, 195))
            .setControl1(new Point(76, 175))
            .setControl2(new Point(76, 135))
            .setEnd(new Point(155, 135))
            .setCheckpoints(checkpoint0)
            .build();

    private static final List<TrackPart> parts = Arrays.asList(
            straight1,
            corner1,
            straight2,
            corner2,
            straight3,
            corner3,
            straight4,
            corner4
    );

    public MainImageTrackPathDefinition() {
        super(0, parts);
    }

}
