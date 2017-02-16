package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.RaceData;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JavaCarPainter extends CarPainter {

    private static final int SIZE = 10;
    private static final int HALF_SIZE = SIZE / 2;

    private final Stroke stroke = new BasicStroke(1);

    private Map<Integer, Color> carColors;

    public JavaCarPainter(TrackDefinition trackDefinition) {
        super(trackDefinition);
    }

    @Override
    public void raceLoaded(RaceData raceData) {
        this.carColors = toColors(raceData.getAllCarStats());
    }

    @Override
    public void paint(CarStats stats, Graphics2D g) {
        Color color = getColor(stats);
        Shape shape = buildShape(stats);

        g.setStroke(stroke);
        g.setColor(color);
        g.fill(shape);
    }

    private Map<Integer, Color> toColors(Iterator<CarStats> carStats) {
        Map<Integer, Color> colors = new HashMap<>();
        while(carStats.hasNext()) {
            CarStats stats = carStats.next();
            Color color = toColor(stats);
            colors.put(stats.getCarId(), color);
        }
        return colors;
    }

    private Color getColor(CarStats stats) {
        return carColors.get(stats.getCarId());
    }

    private Shape buildShape(CarStats stats) {
        TrackPoint point = getLocation(stats);
        int x = point.getX() - HALF_SIZE;
        int y = point.getY() - HALF_SIZE;
        return new Ellipse2D.Float(x, y, SIZE, SIZE);
    }

}
