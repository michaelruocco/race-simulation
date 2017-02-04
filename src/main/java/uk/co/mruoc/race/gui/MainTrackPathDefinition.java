package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.gui.Corner.CornerBuilder;
import uk.co.mruoc.race.gui.Straight.StraightBuilder;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static uk.co.mruoc.race.gui.TrackPartToTrackSplitsConverter.toSplits;

public class MainTrackPathDefinition implements TrackPathDefinition {

    private final Checkpoint checkpoint1 = new Checkpoint(1, BigDecimal.valueOf(0.7));
    private final Checkpoint checkpoint2 = new Checkpoint(2, BigDecimal.valueOf(0.7));
    private final Checkpoint checkpoint3 = new Checkpoint(3, BigDecimal.valueOf(1.0));

    private final Checkpoint checkpoint6 = new Checkpoint(6, BigDecimal.valueOf(1.0));
    private final Checkpoint checkpoint7 = new Checkpoint(7, BigDecimal.valueOf(0.7));
    private final Checkpoint checkpoint8 = new Checkpoint(8, BigDecimal.valueOf(0.0));
    private final Checkpoint checkpoint9 = new Checkpoint(9, BigDecimal.valueOf(0.6));
    private final Checkpoint checkpoint0 = new Checkpoint(0, BigDecimal.valueOf(1.0));

    private final Straight straight1 = new StraightBuilder()
            .setStart(new Point(150, 50))
            .setEnd(new Point(360, 50))
            .setCheckpoints(checkpoint1)
            .build();

    private final Corner corner1 = new CornerBuilder()
            .setStart(new Point(361, 50))
            .setControl1(new Point(450, 50))
            .setControl2(new Point(450, 90))
            .setEnd(new Point(450, 110))
            .setCheckpoints(checkpoint2, checkpoint3)
            .build();

    private final Straight straight2 = new StraightBuilder()
            .setStart(new Point(450, 111))
            .setEnd(new Point(450, 190))
            .build();

    private final Corner corner2 = new CornerBuilder()
            .setStart(new Point(450, 191))
            .setControl1(new Point(450, 210))
            .setControl2(new Point(450, 250))
            .setEnd(new Point(360, 250))
            .setCheckpoints(checkpoint6)
            .build();

    private final Straight straight3 = new StraightBuilder()
            .setStart(new Point(359, 250))
            .setEnd(new Point(150, 250))
            .setCheckpoints(checkpoint7)
            .build();

    private final Corner corner3 = new CornerBuilder()
            .setStart(new Point(149, 250))
            .setControl1(new Point(70, 250))
            .setControl2(new Point(70, 210))
            .setEnd(new Point(70, 190))
            .build();

    private final Straight straight4 = new StraightBuilder()
            .setStart(new Point(70, 189))
            .setEnd(new Point(70, 110))
            .setCheckpoints(checkpoint8, checkpoint9)
            .build();

    private final Corner corner4 = new CornerBuilder()
            .setStart(new Point(70, 109))
            .setControl1(new Point(70, 90))
            .setControl2(new Point(70, 50))
            .setEnd(new Point(149, 50))
            .setCheckpoints(checkpoint0)
            .build();

    private final List<TrackPart> parts = Arrays.asList(
            straight1,
            corner1,
            straight2,
            corner2,
            straight3,
            corner3,
            straight4,
            corner4
    );

    private final List<TrackSplit> splits = toSplits(0, parts);

    @Override
    public List<TrackPart> getParts() {
        return parts;
    }

    @Override
    public List<TrackSplit> getSplits() {
        return splits;
    }

}
