package uk.co.mruoc.race.gui;

import java.awt.*;

import static java.awt.Color.DARK_GRAY;
import static java.awt.Color.WHITE;

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

    public JavaTrackPanel() {
        this(new JavaTrackDefinition());
    }

    private JavaTrackPanel(TrackDefinition trackDefinition) {
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
