package uk.co.mruoc.race.gui;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TrackPointsBuilder {

    public static List<TrackPoint> toTrackPoints(List<AngledPoint> points, List<Checkpoint> checkpoints) {
        List<TrackPoint> trackPoints = toTrackPoints(points);

        for (Checkpoint checkpoint : checkpoints) {
            int index = checkpoint.calculateIndex(points);
            AngledPoint point = points.get(index);
            trackPoints.set(index, new CheckpointTrackPoint(point, checkpoint.getId()));
        }

        return trackPoints;
    }

    private static List<TrackPoint> toTrackPoints(List<AngledPoint> points) {
        List<TrackPoint> trackPoints = new ArrayList<>();
        points.forEach(p -> trackPoints.add(new DefaultTrackPoint(p)));
        return trackPoints;
    }

}
