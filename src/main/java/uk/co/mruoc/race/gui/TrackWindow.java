package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.*;

public class TrackWindow extends JInternalFrame {

    public TrackWindow(JPanel trackPanel) {
        super("Track", false, false, false, true);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(trackPanel, BorderLayout.CENTER);

        setPreferredSize(new Dimension(565, 370));
        pack();
        setVisible(true);
    }

}
