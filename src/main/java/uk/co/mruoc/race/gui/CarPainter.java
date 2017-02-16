package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.RaceDataLoader;
import uk.co.mruoc.race.core.Track;

import java.awt.*;

public abstract class CarPainter implements LoadRaceListener {

    private final CarToColorConverter carToColorConverter = new CarToColorConverter();

    private final TrackDefinition trackDefinition;

    public CarPainter(TrackDefinition trackDefinition) {
        this.trackDefinition = trackDefinition;
    }

    public abstract void paint(CarStats stats, Graphics2D g);

    public Color toColor(CarStats stats) {
        return carToColorConverter.toColor(stats.getCarId());
    }

    public TrackPoint getLocation(CarStats stats) {
        return trackDefinition.getTrackPoint(stats.getSplitId(), stats.getSplitProgress());
    }

}
