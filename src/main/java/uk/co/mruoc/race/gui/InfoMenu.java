package uk.co.mruoc.race.gui;

import javax.swing.*;

public class InfoMenu extends JMenu {

    public InfoMenu(StatWindowActions actions) {
        super("Info");

        add(actions.getShowPositionWindowMenuItem());
        add(actions.getShowSpeedWindowMenuItem());
        add(actions.getShowLapNumberWindowMenuItem());
        add(actions.getShowTimeDifferenceWindowMenuItem());
        add(actions.getShowAverageLapSpeedWindowMenuItem());
        add(actions.getShowMaxAverageLapSpeedWindowMenuItem());
        add(actions.getShowPitStopWindowMenuItem());
        add(actions.getShowRetiredWindowMenuItem());
    }

}
