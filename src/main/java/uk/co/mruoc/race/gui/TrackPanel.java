package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.RaceData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Iterator;

import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

public abstract class TrackPanel extends JPanel implements LoadRaceListener, RaceUpdateListener, ComponentListener {

    private final Dimension defaultSize;
    private final CarPainter carPainter;

    private RaceData raceData;
    private ScaleParams scaleParams;

    public TrackPanel(Dimension defaultSize, CarPainter carPainter) {
        this.defaultSize = defaultSize;
        this.carPainter = carPainter;
        setPreferredSize(defaultSize);
        setOpaque(true);
    }

    public void componentResized(ComponentEvent e) {
        ScaleParams params = calculateScale();
        scale(params);
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        // intentionally blank
    }

    @Override
    public void componentShown(ComponentEvent e) {
        // intentionally blank
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        // intentionally blank
    }

    public void scale(ScaleParams scaleParams) {
        this.scaleParams = scaleParams;
    }

    @Override
    public void raceLoaded(RaceData raceData) {
        carPainter.raceLoaded(raceData);
        update(raceData);
    }

    @Override
    public void raceUpdated(RaceData raceData) {
        update(raceData);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        g2.scale(scaleParams.getX(), scaleParams.getY());

        paintTrack(g2);
        paintCars(g2);
    }

    protected abstract void paintTrack(Graphics2D g);

    private void update(RaceData raceData) {
        this.raceData = raceData;
        repaint();
    }

    private ScaleParams calculateScale() {
        double x = calculateXScale();
        double y = calculateYScale();
        return new ScaleParams(x, y);
    }

    private double calculateXScale() {
        int defaultWidth = defaultSize.width;
        double widthDiff = getWidth() - defaultWidth;
        return 1 + (widthDiff / defaultWidth);
    }

    private double calculateYScale() {
        int defaultHeight = defaultSize.height;
        double heightDiff = getHeight() - defaultHeight;
        return 1 + (heightDiff / defaultHeight);
    }

    private void paintCars(Graphics2D g) {
        Iterator<CarStats> carStats = raceData.getAllCarStats();
        while (carStats.hasNext())
            carPainter.paint(carStats.next(), g);
    }

}
