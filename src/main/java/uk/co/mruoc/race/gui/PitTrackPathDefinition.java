package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.gui.Corner.CornerBuilder;
import uk.co.mruoc.race.gui.Straight.StraightBuilder;

import java.awt.*;
import java.util.*;
import java.util.List;

import static uk.co.mruoc.race.gui.TrackPartToTrackSplitsConverter.toSplits;

public class PitTrackPathDefinition implements TrackPathDefinition {

    private final Checkpoint checkpoint4 = new Checkpoint(4, 0.3);
    private final Checkpoint checkpoint5 = new Checkpoint(5, 0.6);
    private final Checkpoint checkpoint6 = new Checkpoint(6, 1);

    private final Corner corner1 = new CornerBuilder()
            .setStart(new Point(450, 111))
            .setControl1(new Point(450, 130))
            .setControl2(new Point(450, 130))
            .setEnd(new Point(480, 130))
            .build();

    private final Corner corner2 = new CornerBuilder()
            .setStart(new Point(481, 130))
            .setControl1(new Point(490, 130))
            .setControl2(new Point(490, 140))
            .setEnd(new Point(490, 150))
            .setCheckpoints(checkpoint4)
            .build();

    private final Straight straight1 = new StraightBuilder()
            .setStart(new Point(490, 151))
            .setEnd(new Point(490, 155))
            .build();

    private final Corner corner3 = new CornerBuilder()
            .setStart(new Point(490, 156))
            .setControl1(new Point(490, 165))
            .setControl2(new Point(490, 175))
            .setEnd(new Point(480, 175))
            .setCheckpoints(checkpoint5)
            .build();

    private final Corner corner4 = new CornerBuilder()
            .setStart(new Point(479, 175))
            .setControl1(new Point(470, 175))
            .setControl2(new Point(450, 175))
            .setEnd(new Point(450, 190))
            .build();

    private final Corner corner5 = new CornerBuilder()
            .setStart(new Point(450, 191))
            .setControl1(new Point(450, 210))
            .setControl2(new Point(450, 250))
            .setEnd(new Point(360, 250))
            .setCheckpoints(checkpoint6)
            .build();

    private final List<TrackPart> parts = Arrays.asList(
            corner1,
            corner2,
            straight1,
            corner3,
            corner4,
            corner5
    );

    private final List<TrackSplit> splits = toSplits(3, parts);

    @Override
    public List<TrackPart> getParts() {
        return parts;
    }

    @Override
    public List<TrackSplit> getSplits() {
        return splits;
    }

}
