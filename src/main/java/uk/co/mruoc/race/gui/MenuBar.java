package uk.co.mruoc.race.gui;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    public MenuBar(ControlActions controlActions, StatWindowActions statWindowActions) {
        add(new FileMenu(controlActions));
        add(new InfoMenu(statWindowActions));
    }

}
