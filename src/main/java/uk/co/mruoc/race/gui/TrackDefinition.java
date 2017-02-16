package uk.co.mruoc.race.gui;

import org.apache.commons.collections4.ListUtils;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Collection;

public class TrackDefinition {

    private final Shape mainShape;
    private final Shape pitShape;

    private final TrackSplits splits;

    public TrackDefinition(TrackPathDefinition mainPathDefinition, TrackPathDefinition pitPathDefinition) {
        TrackPartsToShapeConverter trackPartsToShapeConverter = new TrackPartsToShapeConverter();
        this.mainShape = trackPartsToShapeConverter.toClosedShape(mainPathDefinition.getParts());
        this.pitShape = trackPartsToShapeConverter.toOpenShape(pitPathDefinition.getParts());
        this.splits = new TrackSplits(ListUtils.union(mainPathDefinition.getSplits(), pitPathDefinition.getSplits()));
    }

    public TrackPoint getTrackPoint(String splitId, BigDecimal splitProgress) {
        return splits.getTrackPoint(splitId, splitProgress);
    }

    public Collection<TrackPoint> getCheckpoints() {
        return splits.getCheckpoints();
    }

    public Shape getMainPath() {
        return mainShape;
    }

    public Shape getPitPath() {
        return pitShape;
    }

}
