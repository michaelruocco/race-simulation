package uk.co.mruoc.race.gui;

import javax.swing.*;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class ShowRetiredPopupWindowAction extends ShowPopupWindowAction {

    private final ImageIcon smallIcon = loadIcon("/uk/co/mruoc/race/gui/icon/retire16.gif");
    private final ImageIcon largeIcon = loadIcon("/uk/co/mruoc/race/gui/icon/retire24.gif");

    public ShowRetiredPopupWindowAction(JInternalFrame window) {
        super(window);
        setSmallIcon(smallIcon);
        setLargeIcon(largeIcon);
        setText("Retired");
    }

}
