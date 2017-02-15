package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.ComponentEvent;
//import java.awt.event.ComponentListener;

public class TrackWindow extends JInternalFrame { //implements ComponentListener {

    //private static final int DEFAULT_WIDTH = 992;
    //private static final int DEFAULT_HEIGHT = 613;

    //private final TrackPanel trackPanel;

    public TrackWindow(TrackPanel trackPanel) {
        super("Track", true, false, true, true);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(trackPanel, BorderLayout.CENTER);

        //setMinimumSize(new Dimension(496, 330));
        //setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        pack();
        addComponentListener(trackPanel);
        setVisible(true);

        //this.trackPanel = trackPanel;
    }

    /*@Override
    public void componentResized(ComponentEvent e) {
        ScaleParams params = calculateScale();
        trackPanel.scale(params);
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

    private ScaleParams calculateScale() {
        double x = calculateXScale();
        double y = calculateYScale();
        return new ScaleParams(x, y);
    }

    private double calculateXScale() {
        double widthDiff = getWidth() - DEFAULT_WIDTH;
        return 1 + (widthDiff / DEFAULT_WIDTH);
    }

    private double calculateYScale() {
        double heightDiff = getHeight() - DEFAULT_HEIGHT;
        return 1 + (heightDiff / DEFAULT_HEIGHT);
    }*/

}
