package uk.co.mruoc.race.gui;

import javax.swing.*;

public abstract class ShowTrackPanelWindowActionFactory {

    private final JInternalFrame window;
    private final TrackPanel trackPanel;

    public ShowTrackPanelWindowActionFactory(JInternalFrame window, TrackPanel trackPanel) {
        this.window = window;
        this.trackPanel = trackPanel;
    }

    protected abstract ShowTrackPanelWindowAction buildAction(JInternalFrame window, JPanel panel);

    public ShowTrackPanelWindowAction buildAction(ControlActions controlActions) {
        ShowTrackPanelWindowAction action = buildAction(window, trackPanel);
        controlActions.addLoadRaceListener(trackPanel);
        controlActions.addRaceUpdateListener(trackPanel);
        return action;
    }

}
