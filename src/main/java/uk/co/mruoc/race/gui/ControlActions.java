package uk.co.mruoc.race.gui;

import javax.swing.*;

public class ControlActions {

    private final Engine engine;

    private final RaceAction showOpenFileDialog;
    private final RaceAction start;
    private final RaceAction stop;
    private final RaceAction reset;
    private final RaceAction showControlDialog;

    public ControlActions(Engine engine, JFrame window) {
        this.engine = engine;

        showOpenFileDialog = new ShowOpenFileDialogAction(engine, window);
        start = new StartAction(engine);
        stop = new StopAction(engine);
        reset = new ResetAction(engine);
        showControlDialog = new ShowControlDialogAction(this, window);
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

}
