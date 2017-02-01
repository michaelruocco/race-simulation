package uk.co.mruoc.race.gui;

import javax.swing.*;

public class WindowActions {

    private final CarTableCellRenderer cellRenderer = new CarTableCellRenderer();

    private final RaceAction showPositionWindow;
    private final RaceAction showSpeedWindow;
    private final RaceAction showLapNumberWindow;
    private final RaceAction showTimeDifferenceWindow;
    private final RaceAction showAverageLapSpeedWindow;
    private final RaceAction showMaxAverageLapSpeedWindow;
    private final RaceAction showPitStopWindow;
    private final RaceAction showRetiredWindow;

    public WindowActions(ControlActions controlActions, JDesktopPane desktop) {
        controlActions.addLoadRaceListener(cellRenderer);

        showPositionWindow = buildShowPositionWindowAction(controlActions, desktop);
        showSpeedWindow = buildShowSpeedWindowAction(controlActions, desktop);
        showLapNumberWindow = buildShowLapNumberWindowAction(controlActions, desktop);
        showTimeDifferenceWindow = buildShowTimeDifferenceWindowAction(controlActions, desktop);
        showAverageLapSpeedWindow = buildShowAverageLapSpeedWindowAction(controlActions, desktop);
        showMaxAverageLapSpeedWindow = buildShowMaximumAverageLapSpeedWindowAction(controlActions, desktop);
        showPitStopWindow = buildShowPitStopWindowAction(controlActions, desktop);
        showRetiredWindow = buildShowRetiredWindowAction(controlActions, desktop);
    }

    private RaceAction buildShowPositionWindowAction(ControlActions controlActions, JDesktopPane desktopPane) {
        ShowStatPopupWindowFactory factory = new ShowPositionPopupWindowFactory(cellRenderer);
        return factory.build(controlActions, desktopPane);
    }

    private RaceAction buildShowSpeedWindowAction(ControlActions controlActions, JDesktopPane desktopPane) {
        ShowStatPopupWindowFactory factory = new ShowSpeedPopupWindowFactory(cellRenderer);
        return factory.build(controlActions, desktopPane);
    }

    private RaceAction buildShowLapNumberWindowAction(ControlActions controlActions, JDesktopPane desktopPane) {
        ShowStatPopupWindowFactory factory = new ShowLapNumberPopupWindowFactory(cellRenderer);
        return factory.build(controlActions, desktopPane);
    }

    private RaceAction buildShowTimeDifferenceWindowAction(ControlActions controlActions, JDesktopPane desktopPane) {
        ShowStatPopupWindowFactory factory = new ShowTimeDifferencePopupWindowFactory(cellRenderer);
        return factory.build(controlActions, desktopPane);
    }

    private RaceAction buildShowAverageLapSpeedWindowAction(ControlActions controlActions, JDesktopPane desktopPane) {
        ShowStatPopupWindowFactory factory = new ShowAverageLapSpeedPopupWindowFactory(cellRenderer);
        return factory.build(controlActions, desktopPane);
    }

    private RaceAction buildShowMaximumAverageLapSpeedWindowAction(ControlActions controlActions, JDesktopPane desktopPane) {
        ShowStatPopupWindowFactory factory = new ShowMaximumAverageLapSpeedPopupWindowFactory(cellRenderer);
        return factory.build(controlActions, desktopPane);
    }

    private RaceAction buildShowPitStopWindowAction(ControlActions controlActions, JDesktopPane desktopPane) {
        ShowStatPopupWindowFactory factory = new ShowPitStopPopupWindowFactory(cellRenderer);
        return factory.build(controlActions, desktopPane);
    }

    private RaceAction buildShowRetiredWindowAction(ControlActions controlActions, JDesktopPane desktopPane) {
        ShowStatPopupWindowFactory factory = new ShowRetiredPopupWindowFactory(cellRenderer);
        return factory.build(controlActions, desktopPane);
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

    public JButton getShowRetiredWindowButton() {
        return new RaceButton(showRetiredWindow);
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

    public JMenuItem getShowRetiredWindowMenuItem() {
        return new JMenuItem(showRetiredWindow);
    }

}
