package uk.co.mruoc.race.gui;

import javax.swing.*;

public class ShowJavaTrackPanelWindowActionFactory extends ShowTrackPanelWindowActionFactory {

    @Override
    protected TrackPanel buildTrackPanel() {
        return new JavaTrackPanel();
    }

    @Override
    protected ShowTrackPanelWindowAction buildAction(JInternalFrame window) {
        return new ShowJavaTrackPanelWindowAction(window);
    }

}
