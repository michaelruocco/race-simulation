package uk.co.mruoc.race.gui;

import javax.swing.*;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class ShowSpeedPopupWindowAction extends ShowPopupWindowAction {

    private final ImageIcon smallIcon = loadIcon("/gui/icons/speed16.gif");
    private final ImageIcon largeIcon = loadIcon("/gui/icons/speed24.gif");

    public ShowSpeedPopupWindowAction(Engine engine, JDesktopPane desktop) {
        super(desktop, new SpeedPopupWindow(engine));
        setSmallIcon(smallIcon);
        setLargeIcon(largeIcon);
        setText("Speed");
    }

}
