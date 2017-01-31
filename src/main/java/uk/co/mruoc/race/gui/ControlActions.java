package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.RaceData;
import uk.co.mruoc.time.ElapsedTime;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ControlActions implements TimeChangeListener, FinishListener, RaceUpdateListener {

    private final Collection<TimeChangeListener> timeChangeListeners = new ArrayList<>();
    private final Collection<FinishListener> finishListeners = new ArrayList<>();
    private final List<RaceUpdateListener> raceUpdateListeners = new ArrayList<>();

    private final ShowOpenFileDialogAction showOpenFileDialog;
    private final ShowControlDialogAction showControlDialog;
    private final ExitAction exit;

    private final StartAction start;
    private final StopAction stop;
    private final ResetAction reset;

    private final RefreshSlider refreshSlider;
    private final SpeedSlider statusSpeedSlider;
    private final SpeedSlider dialogSpeedSlider;

    public ControlActions(Engine engine) {
        showOpenFileDialog = new ShowOpenFileDialogAction();
        showControlDialog = new ShowControlDialogAction(this);
        exit = new ExitAction();

        start = new StartAction();
        stop = new StopAction();
        reset = new ResetAction();

        refreshSlider = new RefreshSlider();
        statusSpeedSlider = new SpeedSlider();
        dialogSpeedSlider = new SpeedSlider();

        statusSpeedSlider.addSpeedUpdateListener(dialogSpeedSlider);
        dialogSpeedSlider.addSpeedUpdateListener(statusSpeedSlider);

        start.addStartListener(start);
        start.addStartListener(stop);
        start.addStartListener(reset);

        stop.addListener(stop);
        stop.addListener(start);

        reset.addListener(start);
        reset.addListener(reset);

        showOpenFileDialog.addLoadRaceListener(start);
        showOpenFileDialog.addLoadRaceListener(stop);
        showOpenFileDialog.addLoadRaceListener(reset);

        setEngine(engine);
    }

    public void setWindow(JFrame window) {
        showOpenFileDialog.setWindow(window);
        showControlDialog.setWindow(window);
        exit.setWindow(window);
    }

    private void setEngine(Engine engine) {
        start.addStartListener(engine);
        stop.addListener(engine);
        reset.addListener(engine);

        start.setEnabled(!engine.isRunning());
        stop.setEnabled(engine.isRunning());
        reset.setEnabled(engine.isStarted());

        showOpenFileDialog.addLoadRaceListener(engine);

        refreshSlider.addRefreshDelayUpdateListener(engine);
        statusSpeedSlider.addSpeedUpdateListener(engine);
        dialogSpeedSlider.addSpeedUpdateListener(engine);

        addFinishListener(start);
        addFinishListener(stop);
    }

    public void addLoadRaceListener(LoadRaceListener listener) {
        showOpenFileDialog.addLoadRaceListener(listener);
    }

    public void addFinishListener(FinishListener listener) {
        finishListeners.add(listener);
    }

    public void addRaceUpdateListener(RaceUpdateListener listener) {
        raceUpdateListeners.add(listener);
    }

    public void addTimeChangeListener(TimeChangeListener listener) {
        timeChangeListeners.add(listener);
    }

    public void loadRace(RaceData raceData) {
        showOpenFileDialog.fireRaceLoaded(raceData);
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

    public JSlider getRefreshSlider() {
        return refreshSlider;
    }

    public JSlider getStatusSpeedSlider() {
        return statusSpeedSlider;
    }

    public JSlider getDialogSpeedSlider() {
        return dialogSpeedSlider;
    }

    @Override
    public void finish() {
        finishListeners.forEach(FinishListener::finish);
    }

    @Override
    public void timeUpdated(ElapsedTime time) {
        timeChangeListeners.forEach(l -> l.timeUpdated(time));
    }

    @Override
    public void raceUpdated(RaceData raceData) {
        raceUpdateListeners.forEach(l -> l.raceUpdated(raceData));
    }

}
