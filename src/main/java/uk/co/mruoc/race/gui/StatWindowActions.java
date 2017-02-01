package uk.co.mruoc.race.gui;

import javax.swing.*;

public class StatWindowActions {

    private final ShowPopupWindowAction positionWindowAction;
    private final ShowPopupWindowAction speedWindowAction;
    private final ShowPopupWindowAction lapNumberWindowAction;
    private final ShowPopupWindowAction timeDifferenceWindowAction;
    private final ShowPopupWindowAction averageLapSpeedWindowAction;
    private final ShowPopupWindowAction maxAverageLapSpeedWindowAction;
    private final ShowPopupWindowAction pitStopWindowAction;
    private final ShowPopupWindowAction retiredWindowAction;

    public StatWindowActions(ControlActions controlActions, JDesktopPane desktop) {
        positionWindowAction = new ShowPositionPopupWindowActionFactory().buildAction(controlActions);
        speedWindowAction = new ShowSpeedPopupWindowActionFactory().buildAction(controlActions);
        lapNumberWindowAction = new ShowLapNumberPopupWindowActionFactory().buildAction(controlActions);
        timeDifferenceWindowAction = new ShowTimeDifferencePopupWindowActionFactory().buildAction(controlActions);
        averageLapSpeedWindowAction = new ShowAverageLapSpeedPopupWindowActionFactory().buildAction(controlActions);
        maxAverageLapSpeedWindowAction = new ShowMaximumAverageLapSpeedPopupWindowActionFactory().buildAction(controlActions);
        pitStopWindowAction = new ShowPitStopPopupWindowActionFactory().buildAction(controlActions);
        retiredWindowAction = new ShowRetiredPopupWindowActionFactory().buildAction(controlActions);

        addWindowsToDesktop(desktop);
    }

    private void addWindowsToDesktop(JDesktopPane desktopPane) {
        desktopPane.add(positionWindowAction.getWindow());
        desktopPane.add(speedWindowAction.getWindow());
        desktopPane.add(lapNumberWindowAction.getWindow());
        desktopPane.add(timeDifferenceWindowAction.getWindow());
        desktopPane.add(averageLapSpeedWindowAction.getWindow());
        desktopPane.add(maxAverageLapSpeedWindowAction.getWindow());
        desktopPane.add(pitStopWindowAction.getWindow());
        desktopPane.add(retiredWindowAction.getWindow());
    }

    public JButton getShowPositionWindowButton() {
        return positionWindowAction.getButton();
    }

    public JButton getShowSpeedWindowButton() {
        return speedWindowAction.getButton();
    }

    public JButton getShowLapNumberWindowButton() {
        return lapNumberWindowAction.getButton();
    }

    public JButton getShowTimeDifferenceWindowButton() {
        return timeDifferenceWindowAction.getButton();
    }

    public JButton getShowAverageLapSpeedWindowButton() {
        return averageLapSpeedWindowAction.getButton();
    }

    public JButton getShowMaxAverageLapSpeedWindowButton() {
        return maxAverageLapSpeedWindowAction.getButton();
    }

    public JButton getShowPitStopWindowButton() {
        return pitStopWindowAction.getButton();
    }

    public JButton getShowRetiredWindowButton() {
        return retiredWindowAction.getButton();
    }

    public JMenuItem getShowPositionWindowMenuItem() {
        return positionWindowAction.getMenuItem();
    }

    public JMenuItem getShowSpeedWindowMenuItem() {
        return speedWindowAction.getMenuItem();
    }

    public JMenuItem getShowLapNumberWindowMenuItem() {
        return lapNumberWindowAction.getMenuItem();
    }

    public JMenuItem getShowTimeDifferenceWindowMenuItem() {
        return timeDifferenceWindowAction.getMenuItem();
    }

    public JMenuItem getShowAverageLapSpeedWindowMenuItem() {
        return averageLapSpeedWindowAction.getMenuItem();
    }

    public JMenuItem getShowMaxAverageLapSpeedWindowMenuItem() {
        return maxAverageLapSpeedWindowAction.getMenuItem();
    }

    public JMenuItem getShowPitStopWindowMenuItem() {
        return pitStopWindowAction.getMenuItem();
    }

    public JMenuItem getShowRetiredWindowMenuItem() {
        return retiredWindowAction.getMenuItem();
    }

}
