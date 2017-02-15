package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class JavaCarPainter implements CarPainter {

    private static final int SIZE = 10;
    private static final int HALF_SIZE = SIZE / 2;

    private final CarToColorConverter carToColorConverter = new CarToColorConverter();

    private final TrackDefinition trackDefinition;

    public JavaCarPainter(TrackDefinition trackDefinition) {
        this.trackDefinition = trackDefinition;
    }

    @Override
    public void paint(CarStats stats, Graphics2D g) {
        Color color = toColor(stats);
        Shape shape = buildShape(stats);

        g.setStroke(new BasicStroke(1));
        g.setColor(color);
        g.fill(shape);
    }

    private Color toColor(CarStats stats) {
        return carToColorConverter.toColor(stats.getCarId());
    }

    private Shape buildShape(CarStats stats) {
        TrackPoint point = trackDefinition.getTrackPoint(stats.getSplitId(), stats.getSplitProgress());
        int x = point.getX() - HALF_SIZE;
        int y = point.getY() - HALF_SIZE;
        return new Ellipse2D.Float(x, y, SIZE, SIZE);
    }

}
