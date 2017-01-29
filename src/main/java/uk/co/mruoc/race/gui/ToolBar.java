package uk.co.mruoc.race.gui;

import javax.swing.*;

public class ToolBar extends JToolBar {

    public ToolBar(Controls controls) {
        add(controls.getStartButton());
        add(controls.getStopButton());
        add(controls.getResetButton());
    }

}
