package uk.co.mruoc.race.gui;

import javax.swing.*;

public class FileMenu extends JMenu {

    public FileMenu(ControlActions actions) {
        super("File");

        add(actions.getStartMenuItem());
        add(actions.getStopMenuItem());
        add(actions.getResetMenuItem());
        add(actions.getShowControlDialogMenuItem());
    }

}
