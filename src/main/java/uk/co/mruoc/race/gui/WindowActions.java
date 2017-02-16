package uk.co.mruoc.race.gui;

import javax.swing.*;

public class WindowActions {

    private final ShowPopupWindowAction positionWindowAction;
    private final ShowPopupWindowAction speedWindowAction;
    private final ShowPopupWindowAction lapNumberWindowAction;
    private final ShowPopupWindowAction timeDifferenceWindowAction;
    private final ShowPopupWindowAction averageLapSpeedWindowAction;
    private final ShowPopupWindowAction maxAverageLapSpeedWindowAction;
    private final ShowPopupWindowAction pitStopWindowAction;
    private final ShowPopupWindowAction retiredWindowAction;

    private final ShowReportPopupWindowAction reportWindowAction;
    private final ShowTrackPanelWindowAction imageTrackPanelWindowAction;
    private final ShowTrackPanelWindowAction javaTrackPanelWindowAction;
    private final ShowPopupWindowAction aboutWindowAction;

    private final JInternalFrame trackWindow;

    public WindowActions(ControlActions controlActions, JDesktopPane desktop, JInternalFrame trackWindow) {
        positionWindowAction = new ShowPositionPopupWindowActionFactory().buildAction(controlActions);
        speedWindowAction = new ShowSpeedPopupWindowActionFactory().buildAction(controlActions);
        lapNumberWindowAction = new ShowLapNumberPopupWindowActionFactory().buildAction(controlActions);
        timeDifferenceWindowAction = new ShowTimeDifferencePopupWindowActionFactory().buildAction(controlActions);
        averageLapSpeedWindowAction = new ShowAverageLapSpeedPopupWindowActionFactory().buildAction(controlActions);
        maxAverageLapSpeedWindowAction = new ShowMaximumAverageLapSpeedPopupWindowActionFactory().buildAction(controlActions);
        pitStopWindowAction = new ShowPitStopPopupWindowActionFactory().buildAction(controlActions);
        retiredWindowAction = new ShowRetiredPopupWindowActionFactory().buildAction(controlActions);

        reportWindowAction = new ShowReportPopupWindowActionFactory().buildAction(controlActions, desktop);

        imageTrackPanelWindowAction = new ShowImageTrackPanelWindowActionFactory(trackWindow).buildAction(controlActions);
        javaTrackPanelWindowAction = new ShowJavaTrackPanelWindowActionFactory(trackWindow).buildAction(controlActions);

        aboutWindowAction = new ShowAboutPopupWindowAction();

        this.trackWindow = trackWindow;

        addWindowsToDesktop(desktop);

        showImageTrackPanelWindow();
    }

    public void showImageTrackPanelWindow() {
        imageTrackPanelWindowAction.showWindow();
    }

    private void addWindowsToDesktop(JDesktopPane desktop) {
        desktop.add(positionWindowAction.getWindow());
        desktop.add(speedWindowAction.getWindow());
        desktop.add(lapNumberWindowAction.getWindow());
        desktop.add(timeDifferenceWindowAction.getWindow());
        desktop.add(averageLapSpeedWindowAction.getWindow());
        desktop.add(maxAverageLapSpeedWindowAction.getWindow());
        desktop.add(pitStopWindowAction.getWindow());
        desktop.add(retiredWindowAction.getWindow());

        desktop.add(aboutWindowAction.getWindow());

        desktop.add(trackWindow);
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

    public JButton getShowReportWindowButton() {
        return reportWindowAction.getButton();
    }

    public JButton getShowAboutWindowButton() {
        return aboutWindowAction.getButton();
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

    public JMenuItem getShowReportWindowMenuItem() {
        return reportWindowAction.getMenuItem();
    }

    public JMenuItem getShowAboutWindowMenuItem() {
        return aboutWindowAction.getMenuItem();
    }

    public JMenuItem getShowImageTrackPanelWindowMenuItem() {
        return imageTrackPanelWindowAction.getMenuItem();
    }

    public JMenuItem getShowJavaTrackPanelWindowMenuItem() {
        return javaTrackPanelWindowAction.getMenuItem();
    }

}
