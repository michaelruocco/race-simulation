package uk.co.mruoc.race.gui;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    public MenuBar(ControlActions controlActions, WindowActions windowActions) {
        add(new FileMenu(controlActions));
        add(new InfoMenu(windowActions));
        add(new TrackMenu(windowActions));
        add(new HelpMenu(windowActions));
    }

}
