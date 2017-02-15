package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.Track;

import java.awt.*;

public interface CarPainter {

    void paint(CarStats stats, Graphics2D g);

}
