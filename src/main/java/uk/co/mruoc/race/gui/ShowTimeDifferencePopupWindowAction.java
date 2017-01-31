package uk.co.mruoc.race.gui;

import javax.swing.*;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class ShowTimeDifferencePopupWindowAction extends ShowPopupWindowAction {

    private final ImageIcon smallIcon = loadIcon("/gui/icons/timediff16.gif");
    private final ImageIcon largeIcon = loadIcon("/gui/icons/timediff24.gif");

    public ShowTimeDifferencePopupWindowAction(JInternalFrame window) {
        super(window);
        setSmallIcon(smallIcon);
        setLargeIcon(largeIcon);
        setText("Time Difference");
    }

}
