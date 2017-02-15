package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.*;

public class TrackWindow extends JInternalFrame {

    public TrackWindow(TrackPanel trackPanel) {
        super("Track", true, false, true, true);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(trackPanel, BorderLayout.CENTER);

        pack();
        addComponentListener(trackPanel);
        setVisible(true);
    }

}
