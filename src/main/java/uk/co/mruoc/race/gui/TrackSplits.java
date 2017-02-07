package uk.co.mruoc.race.gui;

import java.math.BigDecimal;
import java.util.*;

public class TrackSplits {

    private final Map<String, TrackSplit> splits = new HashMap<>();

    public TrackSplits(List<TrackSplit> splitsList) {
        splitsList.forEach(s -> splits.put(s.getId(), s));
    }

    public TrackPoint getTrackPoint(String splitId, BigDecimal splitProgress) {
        TrackSplit split = get(splitId);
        return split.getPointByProgress(splitProgress);
    }

    public Collection<TrackPoint> getCheckpoints() {
        Collection<TrackPoint> checkpoints = new ArrayList<>();
        splits.values().forEach(s -> checkpoints.addAll(s.getCheckpoints()));
        return checkpoints;
    }

    private TrackSplit get(String id) {
        if (splits.containsKey(id))
            return splits.get(id);
        return findSplitWithSameStartCheckpoint(id);
    }

    private TrackSplit findSplitWithSameStartCheckpoint(String id) {
        int startCheckpointId = getStartCheckpointId(id);
        for (String splitId : splits.keySet()) {
            if (startCheckpointId == getStartCheckpointId(splitId))
                return splits.get(splitId);
        }
        throw new IllegalStateException("could not find track split for id " + id);
    }

    private int getStartCheckpointId(String splitId) {
        return Integer.parseInt(splitId.split("-")[0]);
    }

}
