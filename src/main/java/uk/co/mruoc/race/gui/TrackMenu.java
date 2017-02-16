package uk.co.mruoc.race.gui;

import javax.swing.*;

public class TrackMenu extends JMenu {

    public TrackMenu(WindowActions windowActions) {
        super("Track");

        add(windowActions.getShowImageTrackPanelWindowMenuItem());
        add(windowActions.getShowJavaTrackPanelWindowMenuItem());
    }

}
