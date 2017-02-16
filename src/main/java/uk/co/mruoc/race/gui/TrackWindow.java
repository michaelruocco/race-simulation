package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.*;

public class TrackWindow extends JInternalFrame {

    public TrackWindow(TrackPanel trackPanel) {
        super("Track", true, true, true, true);

        Container container = getContentPane();
        container.add(trackPanel);

        pack();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

}
