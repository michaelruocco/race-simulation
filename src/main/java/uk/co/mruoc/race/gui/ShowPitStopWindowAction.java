package uk.co.mruoc.race.gui;

import javax.swing.*;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class ShowPitStopWindowAction extends ShowPopupWindowAction {

    private final ImageIcon smallIcon = loadIcon("/gui/icons/pit16.gif");
    private final ImageIcon largeIcon = loadIcon("/gui/icons/pit24.gif");

    public ShowPitStopWindowAction(Engine engine, JDesktopPane desktop) {
        super(desktop, new PitStopPopupWindow(engine));
        setSmallIcon(smallIcon);
        setLargeIcon(largeIcon);
        setText("Pit Stop");
    }

}
