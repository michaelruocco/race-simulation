package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;

import java.awt.*;

/**
 * Created by michaelruocco on 15/02/2017.
 */
public interface CarPainter {
    void paint(CarStats stats, Graphics2D g);
}
