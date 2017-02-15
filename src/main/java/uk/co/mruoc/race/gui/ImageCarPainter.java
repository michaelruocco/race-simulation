package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;

import java.awt.*;

public class ImageCarPainter implements CarPainter {

    private static final int DEFAULT_WIDTH = 25;
    private static final int DEFAULT_HEIGHT = 49;

    private final CarToColorConverter carToColorConverter = new CarToColorConverter();

    private final TrackDefinition trackDefinition;
    private final Image carImage;

    public ImageCarPainter(TrackDefinition trackDefinition) {
        this.trackDefinition = trackDefinition;
        this.carImage = loadCarImage();
    }

    @Override
    public void paint(CarStats stats, Graphics2D g) {
        Color color = toColor(stats);

        TrackPoint location = getLocation(stats);
        int x = location.getX() - (DEFAULT_WIDTH / 2);
        int y = location.getY() - (DEFAULT_HEIGHT / 2);
        g.drawImage(carImage, x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
    }

    private Image loadCarImage() {
        return ImageLoader.load("/uk/co/mruoc/race/gui/img/car.png");
    }

    private Color toColor(CarStats stats) {
        return carToColorConverter.toColor(stats.getCarId());
    }

    private TrackPoint getLocation(CarStats stats) {
        return trackDefinition.getTrackPoint(stats.getSplitId(), stats.getSplitProgress());
    }

}
