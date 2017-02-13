package uk.co.mruoc.race.gui;

import java.util.ArrayList;
import java.util.List;

import static uk.co.mruoc.race.gui.TrackPartToTrackSplitsConverter.toSplits;

public class TrackPathDefinition implements Scalable<TrackPathDefinition> {

    private final List<TrackPart> parts;
    private final List<TrackSplit> splits;
    private final int startCheckpoint;

    public TrackPathDefinition(int startCheckpoint, List<TrackPart> parts) {
        this.parts = parts;
        this.splits = toSplits(startCheckpoint, parts);
        this.startCheckpoint = startCheckpoint;
    }

    public List<TrackPart> getParts() {
        return parts;
    }

    public List<TrackSplit> getSplits() {
        return splits;
    }

    @Override
    public TrackPathDefinition scale(ScaleParams params) {
        List<TrackPart> scaledParts = new ArrayList<>();
        for (TrackPart part : parts)
            scaledParts.add(part.scale(params));
        return new TrackPathDefinition(startCheckpoint, scaledParts);
    }

}
