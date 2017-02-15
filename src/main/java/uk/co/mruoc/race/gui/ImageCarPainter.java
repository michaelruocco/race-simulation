package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.RaceData;
import uk.co.mruoc.race.core.Track;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ImageCarPainter implements CarPainter, LoadRaceListener {

    private static final int DEFAULT_WIDTH = 25;
    private static final int DEFAULT_HEIGHT = 49;

    private final CarToColorConverter carToColorConverter = new CarToColorConverter();

    private final CarImageBuilder carImageBuilder = new CarImageBuilder();

    private TrackDefinition trackDefinition;
    private Map<Integer, Image> carImages;

    public ImageCarPainter(TrackDefinition trackDefinition) {
        this.trackDefinition = trackDefinition;
    }

    @Override
    public void raceLoaded(RaceData raceData) {
        carImages = new HashMap<>();
        Iterator<CarStats> carStats = raceData.getAllCarStats();
        while(carStats.hasNext()) {
            CarStats stats = carStats.next();
            Color color = toColor(stats);
            Image image = carImageBuilder.build(color);
            carImages.put(stats.getCarId(), image);
        }
    }

    @Override
    public void paint(CarStats stats, Graphics2D g) {
        TrackPoint location = getLocation(stats);
        Image image = carImages.get(stats.getCarId());
        int x = location.getX() - (DEFAULT_WIDTH / 2);
        int y = location.getY() - (DEFAULT_HEIGHT / 2);
        g.drawImage(image, x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
    }

    public void updateTrackDefinition(TrackDefinition trackDefinition) {
        this.trackDefinition = trackDefinition;
    }

    private Color toColor(CarStats stats) {
        return carToColorConverter.toColor(stats.getCarId());
    }

    private TrackPoint getLocation(CarStats stats) {
        return trackDefinition.getTrackPoint(stats.getSplitId(), stats.getSplitProgress());
    }

}
