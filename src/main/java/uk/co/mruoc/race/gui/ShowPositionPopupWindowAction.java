package uk.co.mruoc.race.gui;

import javax.swing.*;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class ShowPositionPopupWindowAction extends ShowPopupWindowAction {

    private final ImageIcon smallIcon = loadIcon("/gui/icons/position16.gif");
    private final ImageIcon largeIcon = loadIcon("/gui/icons/position24.gif");

    public ShowPositionPopupWindowAction(JInternalFrame window) {
        super(window);
        setSmallIcon(smallIcon);
        setLargeIcon(largeIcon);
        setText("Position");
    }

}
