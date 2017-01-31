package uk.co.mruoc.race.gui;

import javax.swing.*;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class ShowAboutPopupWindowAction extends ShowPopupWindowAction {

    private final ImageIcon smallIcon = loadIcon("/toolbarButtonGraphics/general/About16.gif");
    private final ImageIcon largeIcon = loadIcon("/toolbarButtonGraphics/general/About24.gif");

    public ShowAboutPopupWindowAction() {
        super(new AboutPopupWindow());
        setSmallIcon(smallIcon);
        setLargeIcon(largeIcon);
        setText("About");
    }

}
