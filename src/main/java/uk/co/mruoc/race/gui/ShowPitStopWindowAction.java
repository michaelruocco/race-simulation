package uk.co.mruoc.race.gui;

import javax.swing.*;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class ShowPitStopWindowAction extends ShowPopupWindowAction {

    private final ImageIcon smallIcon = loadIcon("/uk/co/mruoc/race/gui/icon/pit16.gif");
    private final ImageIcon largeIcon = loadIcon("/uk/co/mruoc/race/gui/icon/pit24.gif");

    public ShowPitStopWindowAction(JInternalFrame window) {
        super(window);
        setSmallIcon(smallIcon);
        setLargeIcon(largeIcon);
        setText("Pit Stop");
    }

}
