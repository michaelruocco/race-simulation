package uk.co.mruoc.race.gui;

import javax.swing.*;

public class ShowImageTrackPanelWindowActionFactory extends ShowTrackPanelWindowActionFactory {

    @Override
    protected TrackPanel buildTrackPanel() {
        return new ImageTrackPanel();
    }

    @Override
    protected ShowTrackPanelWindowAction buildAction(JInternalFrame window) {
        return new ShowImageTrackPanelWindowAction(window);
    }

}
