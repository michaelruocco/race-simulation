package uk.co.mruoc.race.gui;

import javax.swing.*;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class ShowLapNumberPopupWindowAction extends ShowPopupWindowAction {

    private final ImageIcon smallIcon = loadIcon("/gui/icons/lap16.gif");
    private final ImageIcon largeIcon = loadIcon("/gui/icons/lap24.gif");

    public ShowLapNumberPopupWindowAction(JInternalFrame window) {
        super(window);
        setSmallIcon(smallIcon);
        setLargeIcon(largeIcon);
        setText("Lap Number");
    }

}
