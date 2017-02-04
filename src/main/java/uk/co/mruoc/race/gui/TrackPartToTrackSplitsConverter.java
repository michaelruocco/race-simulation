package uk.co.mruoc.race.gui;

import java.util.ArrayList;
import java.util.List;

public class TrackPartToTrackSplitsConverter {

    public static List<TrackSplit> toSplits(int startCheckpointId, List<TrackPart> trackParts) {
        List<TrackSplit> splits = new ArrayList<>();

        List<TrackPoint> splitPoints = new ArrayList<>();
        for (TrackPart trackPart : trackParts) {
            List<TrackPoint> points = trackPart.getPoints();
            for (TrackPoint trackPoint : points) {
                if (trackPoint instanceof CheckpointTrackPoint) {
                    CheckpointTrackPoint checkpoint = (CheckpointTrackPoint) trackPoint;
                    int endCheckpointId = checkpoint.getId();
                    String id = startCheckpointId + "-" + endCheckpointId;
                    splits.add(new TrackSplit(id, splitPoints));
                    splitPoints = new ArrayList<>();
                    startCheckpointId = endCheckpointId;
                } else {
                    splitPoints.add(trackPoint);
                }
            }
        }

        if (!splitPoints.isEmpty()) {
            String id = startCheckpointId + "-0";
            splits.add(new TrackSplit(id, splitPoints));
        }

        return splits;
    }

}
