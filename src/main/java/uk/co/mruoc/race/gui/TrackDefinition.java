package uk.co.mruoc.race.gui;

import org.apache.commons.collections4.ListUtils;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Collection;

public class TrackDefinition {

    private final TrackPartsToShapeConverter trackPartsToShapeConverter = new TrackPartsToShapeConverter();

    private final TrackPathDefinition mainPathDefinition = new MainTrackPathDefinition();
    private final TrackPathDefinition pitPathDefinition = new PitTrackPathDefinition();

    private final Shape mainShape = trackPartsToShapeConverter.toClosedShape(mainPathDefinition.getParts());
    private final Shape pitShape =  trackPartsToShapeConverter.toOpenShape(pitPathDefinition.getParts());

    private final TrackSplits splits = new TrackSplits(ListUtils.union(mainPathDefinition.getSplits(), pitPathDefinition.getSplits()));

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
