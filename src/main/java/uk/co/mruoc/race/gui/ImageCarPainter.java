package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.RaceData;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ImageCarPainter extends CarPainter {

    private static final int DEFAULT_WIDTH = 25;
    private static final int DEFAULT_HEIGHT = 49;

    private final CarImageBuilder carImageBuilder = new CarImageBuilder();

    private Map<Integer, Image> carImages;

    public ImageCarPainter(TrackDefinition trackDefinition) {
        super(trackDefinition);
    }

    @Override
    public void raceLoaded(RaceData raceData) {
        this.carImages = toImages(raceData.getAllCarStats());
    }

    @Override
    public void paint(CarStats stats, Graphics2D g) {
        TrackPoint location = getLocation(stats);
        Image image = carImages.get(stats.getCarId());
        int x = location.getX() - (DEFAULT_WIDTH / 2);
        int y = location.getY() - (DEFAULT_HEIGHT / 2);
        g.drawImage(image, x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
    }

    private Map<Integer, Image> toImages(Iterator<CarStats> carStats) {
        Map<Integer, Image> images = new HashMap<>();
        while(carStats.hasNext()) {
            CarStats stats = carStats.next();
            Color color = toColor(stats);
            Image image = carImageBuilder.build(color);
            images.put(stats.getCarId(), image);
        }
        return images;
    }

}
