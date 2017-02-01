package uk.co.mruoc.race.gui;

import javax.swing.*;

public class HelpMenu extends JMenu {

    public HelpMenu(WindowActions actions) {
        super("Help");

        add(actions.getShowAboutWindowMenuItem());
    }

}
