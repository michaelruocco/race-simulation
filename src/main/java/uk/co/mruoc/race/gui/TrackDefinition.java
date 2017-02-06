package uk.co.mruoc.race.gui;

import org.apache.commons.collections4.ListUtils;

import java.awt.*;
import java.math.BigDecimal;

public class TrackDefinition {

    private static final int DEFAULT_WIDTH = 541;
    private static final int DEFAULT_HEIGHT = 324;

    private final TrackPartsToShapeConverter trackPartsToShapeConverter = new TrackPartsToShapeConverter();

    private final TrackPathDefinition mainPathDefinition = new MainTrackPathDefinition();
    private final TrackPathDefinition pitPathDefinition = new PitTrackPathDefinition();

    private final Shape mainShape = trackPartsToShapeConverter.toClosedShape(mainPathDefinition.getParts());
    private final Shape pitShape =  trackPartsToShapeConverter.toOpenShape(pitPathDefinition.getParts());

    private final TrackSplits splits = new TrackSplits(ListUtils.union(mainPathDefinition.getSplits(), pitPathDefinition.getSplits()));

    public int getDefaultWidth() {
        return DEFAULT_WIDTH;
    }

    public int getDefaultHeight() {
        return DEFAULT_HEIGHT;
    }

    public TrackPoint getTrackPoint(String splitId, BigDecimal splitProgress) {
        return splits.getTrackPoint(splitId, splitProgress);
    }

    public Shape getMainPath() {
        return mainShape;
    }

    public Shape getPitPath() {
        return pitShape;
    }

}
