package uk.co.mruoc.race.gui;

import javax.swing.*;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class ShowRetiredPopupWindowAction extends ShowPopupWindowAction {

    private final ImageIcon smallIcon = loadIcon("/gui/icons/retire16.gif");
    private final ImageIcon largeIcon = loadIcon("/gui/icons/retire24.gif");

    public ShowRetiredPopupWindowAction(JInternalFrame window) {
        super(window);
        setSmallIcon(smallIcon);
        setLargeIcon(largeIcon);
        setText("Retired");
    }

}
