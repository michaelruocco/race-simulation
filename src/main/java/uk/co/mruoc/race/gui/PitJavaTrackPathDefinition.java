package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.gui.Corner.CornerBuilder;
import uk.co.mruoc.race.gui.Straight.StraightBuilder;

import java.awt.*;
import java.util.*;
import java.util.List;

public class PitJavaTrackPathDefinition extends TrackPathDefinition {

    private static final Checkpoint checkpoint4 = new Checkpoint(4, new Point(486, 132));
    private static final Checkpoint checkpoint5 = new Checkpoint(5, new Point(487, 170));

    private static final Corner corner1 = new CornerBuilder()
            .setStart(new Point(450, 111))
            .setControl1(new Point(450, 130))
            .setControl2(new Point(450, 130))
            .setEnd(new Point(480, 130))
            .build();

    private static final Corner corner2 = new CornerBuilder()
            .setStart(new Point(481, 130))
            .setControl1(new Point(490, 130))
            .setControl2(new Point(490, 140))
            .setEnd(new Point(490, 150))
            .setCheckpoints(checkpoint4)
            .build();

    private static final Straight straight1 = new StraightBuilder()
            .setStart(new Point(490, 151))
            .setEnd(new Point(490, 155))
            .build();

    private static final Corner corner3 = new CornerBuilder()
            .setStart(new Point(490, 156))
            .setControl1(new Point(490, 165))
            .setControl2(new Point(490, 175))
            .setEnd(new Point(480, 175))
            .setCheckpoints(checkpoint5)
            .build();

    private static final Corner corner4 = new CornerBuilder()
            .setStart(new Point(479, 175))
            .setControl1(new Point(470, 175))
            .setControl2(new Point(450, 175))
            .setEnd(new Point(450, 190))
            .build();

    private static final Corner corner5 = new CornerBuilder()
            .setStart(new Point(450, 191))
            .setControl1(new Point(450, 210))
            .setControl2(new Point(450, 250))
            .setEnd(new Point(360, 250))
            .build();

    private static final List<TrackPart> parts = Arrays.asList(
            corner1,
            corner2,
            straight1,
            corner3,
            corner4,
            corner5
    );

    public PitJavaTrackPathDefinition() {
        super(3, parts);
    }

}
