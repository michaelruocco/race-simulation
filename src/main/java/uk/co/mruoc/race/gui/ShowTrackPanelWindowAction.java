package uk.co.mruoc.race.gui;

import javax.swing.*;

public class ShowTrackPanelWindowAction extends ShowPopupWindowAction {

    private final ImageIcon smallIcon = EmptyIcon.getSmall();
    private final ImageIcon largeIcon = EmptyIcon.getLarge();

    public ShowTrackPanelWindowAction(String text, JInternalFrame window) {
        super(window);
        setSmallIcon(smallIcon);
        setLargeIcon(largeIcon);
        setText(text);
    }

}
