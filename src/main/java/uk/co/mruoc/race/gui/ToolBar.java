package uk.co.mruoc.race.gui;

import javax.swing.*;

public class ToolBar extends JToolBar {

    public ToolBar(ControlActions controlActions) {
        add(controlActions.getStartButton());
        add(controlActions.getStopButton());
        add(controlActions.getResetButton());
        add(controlActions.getShowControlDialogButton());
    }

}
