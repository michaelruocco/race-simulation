package uk.co.mruoc.race.gui;

import javax.swing.*;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class ShowTimeDifferencePopupWindowAction extends ShowPopupWindowAction {

    private final ImageIcon smallIcon = loadIcon("/uk/co/mruoc/race/gui/icon/timediff16.gif");
    private final ImageIcon largeIcon = loadIcon("/uk/co/mruoc/race/gui/icon/timediff24.gif");

    public ShowTimeDifferencePopupWindowAction(JInternalFrame window) {
        super(window);
        setSmallIcon(smallIcon);
        setLargeIcon(largeIcon);
        setText("Time Difference");
    }

}
