package uk.co.mruoc.race.gui;

import javax.swing.*;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class ShowAverageLapSpeedAction extends ShowPopupWindowAction {

    private final ImageIcon smallIcon = loadIcon("/gui/icons/lapspeed16.gif");
    private final ImageIcon largeIcon = loadIcon("/gui/icons/lapspeed24.gif");

    public ShowAverageLapSpeedAction(JInternalFrame window) {
        super(window);
        setSmallIcon(smallIcon);
        setLargeIcon(largeIcon);
        setText("Average Lap Speed");
    }

}
