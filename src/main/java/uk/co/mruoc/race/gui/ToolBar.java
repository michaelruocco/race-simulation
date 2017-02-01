package uk.co.mruoc.race.gui;

import javax.swing.*;

public class ToolBar extends JToolBar {

    public ToolBar(ControlActions controlActions, StatWindowActions statWindowActions) {
        add(controlActions.getShowOpenFileDialogButton());
        addSeparator();

        add(controlActions.getStartButton());
        add(controlActions.getStopButton());
        add(controlActions.getResetButton());
        add(controlActions.getShowControlDialogButton());
        addSeparator();

        add(statWindowActions.getShowPositionWindowButton());
        add(statWindowActions.getShowSpeedWindowButton());
        add(statWindowActions.getShowLapNumberWindowButton());
        add(statWindowActions.getShowTimeDifferenceWindowButton());
        add(statWindowActions.getShowAverageLapSpeedWindowButton());
        add(statWindowActions.getShowMaxAverageLapSpeedWindowButton());
        add(statWindowActions.getShowPitStopWindowButton());
        add(statWindowActions.getShowRetiredWindowButton());
    }

}
