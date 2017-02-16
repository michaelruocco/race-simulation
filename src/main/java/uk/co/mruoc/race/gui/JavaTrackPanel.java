package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.RaceData;

import java.awt.*;
import java.util.Iterator;

import static java.awt.Color.DARK_GRAY;
import static java.awt.Color.WHITE;
import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

public class JavaTrackPanel extends TrackPanel {

    private static final int DEFAULT_WIDTH = 541;
    private static final int DEFAULT_HEIGHT = 324;

    private static final Color DARK_GREEN = new Color(0, 100, 0);
    private static final Color EDGE_COLOR = WHITE;
    private static final Color TRACK_COLOR = DARK_GRAY;

    private final int MAIN_WIDTH = 50;
    private final int PIT_WIDTH = 15;
    private final int EDGE_WIDTH = 3;

    private final TrackDefinition trackDefinition;

    public JavaTrackPanel(TrackDefinition trackDefinition) {
        super(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT), new JavaCarPainter(trackDefinition));
        setBackground(DARK_GREEN);
        this.trackDefinition = trackDefinition;
    }

    @Override
    protected void paintTrack(Graphics2D g) {
        paintEdge(g);
        paintPitTrack(g);
        paintMainTrack(g);
    }

    private void paintEdge(Graphics2D g) {
        paintPitEdge(g);
        paintMainEdge(g);
    }

    private void paintPitEdge(Graphics2D g) {
        g.setColor(EDGE_COLOR);
        g.setStroke(new BasicStroke(PIT_WIDTH));
        g.draw(trackDefinition.getPitPath());
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

    private void paintPitTrack(Graphics2D g) {
        g.setColor(TRACK_COLOR);
        g.setStroke(new BasicStroke(PIT_WIDTH - EDGE_WIDTH));
        g.draw(trackDefinition.getPitPath());
    }

}
