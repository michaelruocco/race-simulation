package uk.co.mruoc.race.gui;

import java.awt.*;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Corner implements TrackPart {

    private final CubicCurve2D curve;
    private final List<TrackPoint> trackPoints;

    private Corner(CornerBuilder builder) {
        this.curve = builder.getCurve();
        List<Checkpoint> checkpoints = builder.checkpoints;
        List<AngledPoint> points = toPoints(curve);
        this.trackPoints = TrackPointsBuilder.toTrackPoints(points, checkpoints);
    }

    @Override
    public List<TrackPoint> getPoints() {
        return trackPoints;
    }

    @Override
    public void moveToStart(GeneralPath path) {
        path.moveTo(curve.getX1(), curve.getY1());
    }

    @Override
    public void appendTo(GeneralPath path) {
        path.append(curve, true);
    }

    private List<AngledPoint> toPoints(CubicCurve2D curve) {
        List<AngledPoint> points = new ArrayList<>();
        for(double t=0; t<=1; t+=0.01) {
            int x = calculateX(t, curve);
            int y = calculateY(t, curve);
            points.add(new AngledPoint(x, y, 90));
        }
        return points;
    }

    private static int calculateX(double t, CubicCurve2D curve) {
        return (int) (Math.pow(1-t, 3)*curve.getX1()+3*Math.pow(1-t, 2)*t*curve.getCtrlX1()+3*(1-t)*t*t*curve.getCtrlX2()+t*t*t*curve.getX2());
    }

    private static int calculateY(double t, CubicCurve2D curve) {
        return (int) (Math.pow(1-t, 3)*curve.getY1()+3*Math.pow(1-t, 2)*t*curve.getCtrlY1()+3*(1-t)*t*t*curve.getCtrlY2()+t*t*t*curve.getY2());
    }

    public static class CornerBuilder {

        private Point start;
        private Point control1;
        private Point control2;
        private Point end;
        private List<Checkpoint> checkpoints = Collections.emptyList();

        public CornerBuilder setStart(Point start) {
            this.start = start;
            return this;
        }

        public CornerBuilder setControl1(Point control1) {
            this.control1 = control1;
            return this;
        }

        public CornerBuilder setControl2(Point control2) {
            this.control2 = control2;
            return this;
        }

        public CornerBuilder setEnd(Point end) {
            this.end = end;
            return this;
        }

        public CornerBuilder setCheckpoints(Checkpoint... checkpoints) {
            return setCheckpoints(Arrays.asList(checkpoints));
        }

        public CornerBuilder setCheckpoints(List<Checkpoint> checkpoints) {
            this.checkpoints = checkpoints;
            return this;
        }

        private CubicCurve2D getCurve() {
            CubicCurve2D curve = new CubicCurve2D.Float();
            curve.setCurve(start, control1, control2, end);
            return curve;
        }

        public Corner build() {
            return new Corner(this);
        }

    }

}
