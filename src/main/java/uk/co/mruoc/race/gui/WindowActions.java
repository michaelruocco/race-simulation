package uk.co.mruoc.race.gui;

import javax.swing.*;

public class WindowActions {

    private final RaceAction showPositionWindow;
    private final RaceAction showSpeedWindow;
    private final RaceAction showLapNumberWindow;
    private final RaceAction showTimeDifferenceWindow;
    private final RaceAction showAverageLapSpeedWindow;
    private final RaceAction showMaxAverageLapSpeedWindow;
    private final RaceAction showPitStopWindow;

    public WindowActions(Engine engine, JDesktopPane desktop) {
        showPositionWindow = new ShowPositionPopupWindowAction(engine, desktop);
        showSpeedWindow = new ShowSpeedPopupWindowAction(engine, desktop);
        showLapNumberWindow = new ShowLapNumberPopupWindowAction(engine, desktop);
        showTimeDifferenceWindow = new ShowTimeDifferencePopupWindowAction(engine, desktop);
        showAverageLapSpeedWindow = new ShowAverageLapSpeedAction(engine, desktop);
        showMaxAverageLapSpeedWindow = new ShowMaximumAverageLapSpeedAction(engine, desktop);
        showPitStopWindow = new ShowPitStopWindowAction(engine, desktop);
    }

    public JButton getShowPositionWindowButton() {
        return new RaceButton(showPositionWindow);
    }

    public JButton getShowSpeedWindowButton() {
        return new RaceButton(showSpeedWindow);
    }

    public JButton getShowLapNumberWindowButton() {
        return new RaceButton(showLapNumberWindow);
    }

    public JButton getShowTimeDifferenceWindowButton() {
        return new RaceButton(showTimeDifferenceWindow);
    }

    public JButton getShowAverageLapSpeedWindowButton() {
        return new RaceButton(showAverageLapSpeedWindow);
    }

    public JButton getShowMaxAverageLapSpeedWindowButton() {
        return new RaceButton(showMaxAverageLapSpeedWindow);
    }

    public JButton getShowPitStopWindowButton() {
        return new RaceButton(showPitStopWindow);
    }

    public JMenuItem getShowPositionWindowMenuItem() {
        return new JMenuItem(showPositionWindow);
    }

    public JMenuItem getShowSpeedWindowMenuItem() {
        return new JMenuItem(showSpeedWindow);
    }

    public JMenuItem getShowLapNumberWindowMenuItem() {
        return new JMenuItem(showLapNumberWindow);
    }

    public JMenuItem getShowTimeDifferenceWindowMenuItem() {
        return new JMenuItem(showTimeDifferenceWindow);
    }

    public JMenuItem getShowAverageLapSpeedWindowMenuItem() {
        return new JMenuItem(showAverageLapSpeedWindow);
    }

    public JMenuItem getShowMaxAverageLapSpeedWindowMenuItem() {
        return new JMenuItem(showMaxAverageLapSpeedWindow);
    }

    public JMenuItem getShowPitStopWindowMenuItem() {
        return new JMenuItem(showPitStopWindow);
    }

}
