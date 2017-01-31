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
        AbstractCarStatTableModel tableModel = new PositionTableModel();
        controlActions.addTimeChangeListener(tableModel);
        controlActions.addLoadRaceListener(tableModel);

        JInternalFrame window = new PositionPopupWindow(tableModel, cellRenderer);
        desktopPane.add(window);

        return new ShowPositionPopupWindowAction(window);
    }

    private RaceAction buildShowSpeedWindowAction(ControlActions controlActions, JDesktopPane desktopPane) {
        AbstractCarStatTableModel tableModel = new SpeedTableModel();
        controlActions.addTimeChangeListener(tableModel);
        controlActions.addLoadRaceListener(tableModel);

        JInternalFrame window = new SpeedPopupWindow(tableModel, cellRenderer);
        desktopPane.add(window);

        return new ShowSpeedPopupWindowAction(window);
    }

    private RaceAction buildShowLapNumberWindowAction(ControlActions controlActions, JDesktopPane desktopPane) {
        AbstractCarStatTableModel tableModel = new LapNumberTableModel();
        controlActions.addTimeChangeListener(tableModel);
        controlActions.addLoadRaceListener(tableModel);

        JInternalFrame window = new LapNumberPopupWindow(tableModel, cellRenderer);
        desktopPane.add(window);

        return new ShowLapNumberPopupWindowAction(window);
    }

    private RaceAction buildShowTimeDifferenceWindowAction(ControlActions controlActions, JDesktopPane desktopPane) {
        AbstractCarStatTableModel tableModel = new TimeDifferenceTableModel();
        controlActions.addTimeChangeListener(tableModel);
        controlActions.addLoadRaceListener(tableModel);

        JInternalFrame window = new TimeDifferencePopupWindow(tableModel, cellRenderer);
        desktopPane.add(window);

        return new ShowTimeDifferencePopupWindowAction(window);
    }

    private RaceAction buildShowAverageLapSpeedWindowAction(ControlActions controlActions, JDesktopPane desktopPane) {
        AbstractCarStatTableModel tableModel = new AverageLapSpeedTableModel();
        controlActions.addTimeChangeListener(tableModel);
        controlActions.addLoadRaceListener(tableModel);

        JInternalFrame window = new AverageLapSpeedPopupWindow(tableModel, cellRenderer);
        desktopPane.add(window);

        return new ShowAverageLapSpeedAction(window);
    }

    private RaceAction buildShowMaximumAverageLapSpeedWindowAction(ControlActions controlActions, JDesktopPane desktopPane) {
        AbstractCarStatTableModel tableModel = new MaximumAverageLapSpeedTableModel();
        controlActions.addTimeChangeListener(tableModel);
        controlActions.addLoadRaceListener(tableModel);

        JInternalFrame window = new MaximumAverageLapSpeedPopupWindow(tableModel, cellRenderer);
        desktopPane.add(window);

        return new ShowMaximumAverageLapSpeedAction(window);
    }

    private RaceAction buildShowPitStopWindowAction(ControlActions controlActions, JDesktopPane desktopPane) {
        AbstractCarStatTableModel tableModel = new PitStopTableModel();
        controlActions.addTimeChangeListener(tableModel);
        controlActions.addLoadRaceListener(tableModel);

        JInternalFrame window = new PitStopPopupWindow(tableModel, cellRenderer);
        desktopPane.add(window);

        return new ShowPitStopWindowAction(window);
    }

    private RaceAction buildShowRetiredWindowAction(ControlActions controlActions, JDesktopPane desktopPane) {
        AbstractCarStatTableModel tableModel = new RetiredTableModel();
        controlActions.addTimeChangeListener(tableModel);
        controlActions.addLoadRaceListener(tableModel);

        JInternalFrame window = new RetiredPopupWindow(tableModel, cellRenderer);
        desktopPane.add(window);

        return new ShowRetiredPopupWindowAction(window);
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
