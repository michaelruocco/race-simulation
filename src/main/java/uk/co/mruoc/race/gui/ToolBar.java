package uk.co.mruoc.race.gui;

import javax.swing.*;

public class ToolBar extends JToolBar {

    public ToolBar(ControlActions controlActions, WindowActions windowActions) {
        add(controlActions.getShowOpenFileDialogButton());
        addSeparator();

        add(controlActions.getStartButton());
        add(controlActions.getStopButton());
        add(controlActions.getResetButton());
        add(controlActions.getShowControlDialogButton());
        addSeparator();

        add(windowActions.getShowPositionWindowButton());
        add(windowActions.getShowSpeedWindowButton());
        add(windowActions.getShowLapNumberWindowButton());
        add(windowActions.getShowTimeDifferenceWindowButton());
        add(windowActions.getShowAverageLapSpeedWindowButton());
        add(windowActions.getShowMaxAverageLapSpeedWindowButton());
        add(windowActions.getShowPitStopWindowButton());
        add(windowActions.getShowRetiredWindowButton());
        addSeparator();

        add(windowActions.getShowReportWindowButton());
        addSeparator();

        add(windowActions.getShowAboutWindowButton());
    }

}
