package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.RaceData;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Collection;
import java.util.Iterator;

import static java.awt.Color.DARK_GRAY;
import static java.awt.Color.GRAY;
import static java.awt.Color.WHITE;
import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

public class JavaTrackPanel extends TrackPanel {

    private static final Color DARK_GREEN = new Color(0, 100, 0);
    private static final Color EDGE_COLOR = WHITE;
    private static final Color TRACK_COLOR = DARK_GRAY;

    private final int MAIN_WIDTH = 50;
    private final int PIT_WIDTH = 15;
    private final int EDGE_WIDTH = 3;

    private final TrackDefinition trackDefinition;
    private final CarPainter carPainter;

    private RaceData raceData;
    private double xScale;
    private double yScale;

    public JavaTrackPanel(TrackDefinition trackDefinition) {
        setOpaque(true);
        setBackground(DARK_GREEN);

        this.trackDefinition = trackDefinition;
        this.carPainter = new CarPainter(trackDefinition);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        g2.scale(xScale, yScale);

        paintEdge(g2);
        paintTrack(g2);
        paintCheckpoints(g2);
        paintCars(g2);
    }

    @Override
    public void updateScale(double xScale, double yScale) {
        this.xScale = xScale;
        this.yScale = yScale;
    }

    @Override
    public void raceLoaded(RaceData raceData) {
        update(raceData);
    }

    @Override
    public void raceUpdated(RaceData raceData) {
        update(raceData);
    }

    private void update(RaceData raceData) {
        this.raceData = raceData;
        repaint();
    }

    private void paintEdge(Graphics2D g) {
        paintPitEdge(g);
        paintMainEdge(g);
    }

    private void paintTrack(Graphics2D g) {
        paintPitTrack(g);
        paintMainTrack(g);
    }

    private void paintMainEdge(Graphics2D g) {
        g.setColor(EDGE_COLOR);
        g.setStroke(new BasicStroke(MAIN_WIDTH));
        g.draw(trackDefinition.getMainPath());
    }

    private void paintMainTrack(Graphics2D g) {
        g.setColor(TRACK_COLOR);
        g.setStroke(new BasicStroke(MAIN_WIDTH - EDGE_WIDTH));
        g.draw(trackDefinition.getMainPath());
    }

    private void paintPitEdge(Graphics2D g) {
        g.setColor(EDGE_COLOR);
        g.setStroke(new BasicStroke(PIT_WIDTH));
        g.draw(trackDefinition.getPitPath());
    }

    private void paintPitTrack(Graphics2D g) {
        g.setColor(TRACK_COLOR);
        g.setStroke(new BasicStroke(PIT_WIDTH - EDGE_WIDTH));
        g.draw(trackDefinition.getPitPath());
    }

    private void paintCheckpoints(Graphics2D g) {
        Collection<TrackPoint> checkpoints = trackDefinition.getCheckpoints();
        for (TrackPoint checkpoint : checkpoints)
            checkpoint.paint(g);
    }

    private void paintCars(Graphics2D g) {
        Iterator<CarStats> carStats = raceData.getAllCarStats();
        while (carStats.hasNext())
            carPainter.paint(carStats.next(), g);
    }

}
