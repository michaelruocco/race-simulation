package uk.co.mruoc.race.gui;

import java.util.List;

import static uk.co.mruoc.race.gui.TrackPartToTrackSplitsConverter.toSplits;

public class TrackPathDefinition {

    private final List<TrackPart> parts;
    private final List<TrackSplit> splits;

    public TrackPathDefinition(int startCheckpoint, List<TrackPart> parts) {
        this.parts = parts;
        this.splits = toSplits(startCheckpoint, parts);
    }

    public List<TrackPart> getParts() {
        return parts;
    }

    public List<TrackSplit> getSplits() {
        return splits;
    }

}
