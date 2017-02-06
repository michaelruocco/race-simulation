package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class TrackWindow extends JInternalFrame {

    private static final int DEFAULT_WIDTH = 565;
    private static final int DEFAULT_HEIGHT = 370;

    public TrackWindow(TrackPanel trackPanel) {
        super("Track", true, false, true, true);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(trackPanel, BorderLayout.CENTER);

        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        pack();
        addComponentListener(trackPanel);
        setVisible(true);
    }

}
