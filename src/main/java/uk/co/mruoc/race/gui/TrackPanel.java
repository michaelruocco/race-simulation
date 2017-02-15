package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public abstract class TrackPanel extends JPanel implements LoadRaceListener, RaceUpdateListener, ComponentListener {

    private final Dimension defaultSize;

    public TrackPanel(Dimension defaultSize) {
        this.defaultSize = defaultSize;
        setPreferredSize(defaultSize);
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

    protected abstract void scale(ScaleParams params);

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

}
