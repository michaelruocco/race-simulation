package uk.co.mruoc.race.gui;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TrackSplit {

    private final String id;
    private final List<TrackPoint> points;

    public TrackSplit(String id, List<TrackPoint> points) {
        this.id = id;
        this.points = points;
    }

    public String getId() {
        return id;
    }

    public TrackPoint getPointByProgress(BigDecimal progress) {
        int index = toIndex(progress);
        return points.get(index);
    }

    private int toIndex(BigDecimal progress) {
        int index = progress.multiply(BigDecimal.valueOf(points.size())).intValue();
        return Math.min(index, points.size() - 1);
    }

}
