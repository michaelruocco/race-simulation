package uk.co.mruoc.race.gui;

import javax.swing.*;

public class ToolBar extends JToolBar {

    public ToolBar(ControlActions controlActions, WindowActions windowActions) {
        add(controlActions.getStartButton());
        add(controlActions.getStopButton());
        add(controlActions.getResetButton());
        add(controlActions.getShowControlDialogButton());
        addSeparator();
        add(windowActions.getShowPositionWindowButton());
    }

}
