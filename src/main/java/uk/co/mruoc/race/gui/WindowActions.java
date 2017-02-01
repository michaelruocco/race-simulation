package uk.co.mruoc.race.gui;

import javax.swing.*;

public class WindowActions {

    private final ShowStatPopupWindowFactory positionWindowFactory;
    private final ShowStatPopupWindowFactory speedWindowFactory;
    private final ShowStatPopupWindowFactory lapNumberWindowFactory;
    private final ShowStatPopupWindowFactory timeDifferenceWindowFactory;
    private final ShowStatPopupWindowFactory averageLapSpeedWindowFactory;
    private final ShowStatPopupWindowFactory maxAverageLapSpeedWindowFactory;
    private final ShowStatPopupWindowFactory pitStopWindowFactory;
    private final ShowStatPopupWindowFactory retiredWindowFactory;

    public WindowActions(ControlActions controlActions, JDesktopPane desktop) {
        positionWindowFactory = new ShowPositionPopupWindowFactory(controlActions);
        speedWindowFactory = new ShowSpeedPopupWindowFactory(controlActions);
        lapNumberWindowFactory = new ShowLapNumberPopupWindowFactory(controlActions);
        timeDifferenceWindowFactory = new ShowTimeDifferencePopupWindowFactory(controlActions);
        averageLapSpeedWindowFactory = new ShowAverageLapSpeedPopupWindowFactory(controlActions);
        maxAverageLapSpeedWindowFactory = new ShowMaximumAverageLapSpeedPopupWindowFactory(controlActions);
        pitStopWindowFactory = new ShowPitStopPopupWindowFactory(controlActions);
        retiredWindowFactory = new ShowRetiredPopupWindowFactory(controlActions);

        addWindowsToDesktop(desktop);
    }

    private void addWindowsToDesktop(JDesktopPane desktopPane) {
        desktopPane.add(positionWindowFactory.getWindow());
        desktopPane.add(speedWindowFactory.getWindow());
        desktopPane.add(lapNumberWindowFactory.getWindow());
        desktopPane.add(timeDifferenceWindowFactory.getWindow());
        desktopPane.add(averageLapSpeedWindowFactory.getWindow());
        desktopPane.add(maxAverageLapSpeedWindowFactory.getWindow());
        desktopPane.add(pitStopWindowFactory.getWindow());
        desktopPane.add(retiredWindowFactory.getWindow());
    }

    public JButton getShowPositionWindowButton() {
        return positionWindowFactory.getButton();
    }

    public JButton getShowSpeedWindowButton() {
        return speedWindowFactory.getButton();
    }

    public JButton getShowLapNumberWindowButton() {
        return lapNumberWindowFactory.getButton();
    }

    public JButton getShowTimeDifferenceWindowButton() {
        return timeDifferenceWindowFactory.getButton();
    }

    public JButton getShowAverageLapSpeedWindowButton() {
        return averageLapSpeedWindowFactory.getButton();
    }

    public JButton getShowMaxAverageLapSpeedWindowButton() {
        return maxAverageLapSpeedWindowFactory.getButton();
    }

    public JButton getShowPitStopWindowButton() {
        return pitStopWindowFactory.getButton();
    }

    public JButton getShowRetiredWindowButton() {
        return retiredWindowFactory.getButton();
    }

    public JMenuItem getShowPositionWindowMenuItem() {
        return positionWindowFactory.getMenuItem();
    }

    public JMenuItem getShowSpeedWindowMenuItem() {
        return speedWindowFactory.getMenuItem();
    }

    public JMenuItem getShowLapNumberWindowMenuItem() {
        return lapNumberWindowFactory.getMenuItem();
    }

    public JMenuItem getShowTimeDifferenceWindowMenuItem() {
        return timeDifferenceWindowFactory.getMenuItem();
    }

    public JMenuItem getShowAverageLapSpeedWindowMenuItem() {
        return averageLapSpeedWindowFactory.getMenuItem();
    }

    public JMenuItem getShowMaxAverageLapSpeedWindowMenuItem() {
        return maxAverageLapSpeedWindowFactory.getMenuItem();
    }

    public JMenuItem getShowPitStopWindowMenuItem() {
        return pitStopWindowFactory.getMenuItem();
    }

    public JMenuItem getShowRetiredWindowMenuItem() {
        return retiredWindowFactory.getMenuItem();
    }

}
