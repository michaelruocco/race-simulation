package uk.co.mruoc.race.gui;

import javax.swing.*;

public abstract class ShowTrackPanelWindowActionFactory {

    protected abstract TrackPanel buildTrackPanel();

    protected abstract ShowTrackPanelWindowAction buildAction(JInternalFrame window);

    public ShowTrackPanelWindowAction buildAction(ControlActions controlActions) {
        TrackPanel trackPanel = buildTrackPanel();
        ShowTrackPanelWindowAction action = buildAction(new TrackWindow(trackPanel));
        controlActions.addLoadRaceListener(trackPanel);
        controlActions.addRaceUpdateListener(trackPanel);
        return action;
    }

}
