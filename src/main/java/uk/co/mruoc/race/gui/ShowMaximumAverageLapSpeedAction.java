package uk.co.mruoc.race.gui;

import javax.swing.*;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class ShowMaximumAverageLapSpeedAction extends ShowPopupWindowAction {

    private final ImageIcon smallIcon = loadIcon("/gui/icons/bestlap16.gif");
    private final ImageIcon largeIcon = loadIcon("/gui/icons/bestlap24.gif");

    public ShowMaximumAverageLapSpeedAction(Engine engine, JDesktopPane desktop) {
        super(desktop, new MaximumAverageLapSpeedPopupWindow(engine));
        setSmallIcon(smallIcon);
        setLargeIcon(largeIcon);
        setText("Maximum Average Lap Speed");
    }

}
