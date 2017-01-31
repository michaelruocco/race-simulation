package uk.co.mruoc.race.gui;

import javax.swing.*;

public class ControlActions {

    private final Engine engine;

    private final RaceAction showOpenFileDialog;
    private final StartAction start;
    private final StopAction stop;
    private final ResetAction reset;
    private final RaceAction showControlDialog;
    private final RaceAction exit;

    public ControlActions(Engine engine, JFrame window) {
        this.engine = engine;

        showOpenFileDialog = new ShowOpenFileDialogAction(engine, window);
        start = new StartAction();
        stop = new StopAction(engine);
        reset = new ResetAction();
        showControlDialog = new ShowControlDialogAction(this, window);
        exit = new ExitAction(window);

        start.addStartListener(start);
        start.addStartListener(stop);
        start.addStartListener(reset);
        start.addStartListener(engine);

        stop.addListener(stop);
        stop.addListener(start);
        stop.addListener(engine);

        reset.addListener(start);
        reset.addListener(reset);
        reset.addListener(engine);

        start.setEnabled(!engine.isRunning());
        stop.setEnabled(engine.isRunning());
        reset.setEnabled(engine.isStarted());
    }

    public JButton getShowOpenFileDialogButton() {
        return new RaceButton(showOpenFileDialog);
    }

    public JButton getStartButton() {
        return new RaceButton(start);
    }

    public JButton getStopButton() {
        return new RaceButton(stop);
    }

    public JButton getResetButton() {
        return new RaceButton(reset);
    }

    public JButton getShowControlDialogButton() {
        return new RaceButton(showControlDialog);
    }

    public JSlider getSpeedSlider() {
        return new SpeedSlider(engine);
    }

    public JSlider getRefreshSlider() {
        return new RefreshSlider(engine);
    }

    public JMenuItem getShowOpenFileDialogMenuItem() {
        return new JMenuItem(showOpenFileDialog);
    }

    public JMenuItem getStartMenuItem() {
        return new JMenuItem(start);
    }

    public JMenuItem getStopMenuItem() {
        return new JMenuItem(stop);
    }

    public JMenuItem getResetMenuItem() {
        return new JMenuItem(reset);
    }

    public JMenuItem getShowControlDialogMenuItem() {
        return new JMenuItem(showControlDialog);
    }

    public JMenuItem getExitDialogMenuItem() {
        return new JMenuItem(exit);
    }

}
