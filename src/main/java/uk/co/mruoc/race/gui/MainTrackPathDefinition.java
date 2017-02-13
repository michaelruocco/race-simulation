package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.gui.Corner.CornerBuilder;
import uk.co.mruoc.race.gui.Straight.StraightBuilder;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static uk.co.mruoc.race.gui.TrackPartToTrackSplitsConverter.toSplits;

public class MainTrackPathDefinition extends TrackPathDefinition {

    private static final Checkpoint checkpoint1 = new Checkpoint(1, new Point(297, 50));
    private static final Checkpoint checkpoint2 = new Checkpoint(2, new Point(447, 88));
    private static final Checkpoint checkpoint3 = new Checkpoint(3, new Point(449, 109));

    private static final Checkpoint checkpoint6 = new Checkpoint(6, new Point(359, 250));
    private static final Checkpoint checkpoint7 = new Checkpoint(7, new Point(212, 250));
    private static final Checkpoint checkpoint8 = new Checkpoint(8, new Point(70, 189));
    private static final Checkpoint checkpoint9 = new Checkpoint(9, new Point(70, 141));
    private static final Checkpoint checkpoint0 = new Checkpoint(0, new Point(146, 50));

    private static final TrackPart straight1 = new StraightBuilder()
            .setStart(new Point(150, 50))
            .setEnd(new Point(360, 50))
            .setCheckpoints(checkpoint1)
            .build();

    private static final TrackPart corner1 = new CornerBuilder()
            .setStart(new Point(361, 50))
            .setControl1(new Point(450, 50))
            .setControl2(new Point(450, 90))
            .setEnd(new Point(450, 110))
            .setCheckpoints(checkpoint2, checkpoint3)
            .build();

    private static final TrackPart straight2 = new StraightBuilder()
            .setStart(new Point(450, 111))
            .setEnd(new Point(450, 190))
            .build();

    private static final TrackPart corner2 = new CornerBuilder()
            .setStart(new Point(450, 191))
            .setControl1(new Point(450, 210))
            .setControl2(new Point(450, 250))
            .setEnd(new Point(360, 250))
            .build();

    private static final TrackPart straight3 = new StraightBuilder()
            .setStart(new Point(359, 250))
            .setEnd(new Point(150, 250))
            .setCheckpoints(checkpoint6, checkpoint7)
            .build();

    private static final TrackPart corner3 = new CornerBuilder()
            .setStart(new Point(149, 250))
            .setControl1(new Point(70, 250))
            .setControl2(new Point(70, 210))
            .setEnd(new Point(70, 190))
            .build();

    private static final TrackPart straight4 = new StraightBuilder()
            .setStart(new Point(70, 189))
            .setEnd(new Point(70, 110))
            .setCheckpoints(checkpoint8, checkpoint9)
            .build();

    private static final TrackPart corner4 = new CornerBuilder()
            .setStart(new Point(70, 109))
            .setControl1(new Point(70, 90))
            .setControl2(new Point(70, 50))
            .setEnd(new Point(149, 50))
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

    public MainTrackPathDefinition() {
        super(0, parts);
    }

}
