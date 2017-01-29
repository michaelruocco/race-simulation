package uk.co.mruoc.race.gui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.co.mruoc.race.core.RaceData;
import uk.co.mruoc.time.ElapsedTime;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class Engine implements ActionListener, StartListener, StopListener, ResetListener, FinishListener, RefreshDelayListener {

    private static final Logger LOG = LogManager.getLogger(Engine.class);

    private final Collection<TimeChangeListener> timeChangeListeners = new ArrayList<>();
    private final Collection<StartListener> startListeners = new ArrayList<>();
    private final Collection<StopListener> stopListeners = new ArrayList<>();
    private final Collection<ResetListener> resetListeners = new ArrayList<>();
    private final Collection<FinishListener> finishListeners = new ArrayList<>();
    private final Collection<LoadRaceListener> loadRaceListeners = new ArrayList<>();
    private final Collection<RaceUpdateListener> raceUpdateListeners = new ArrayList<>();

    private final Timer timer;

    private RaceData raceData;
    private ElapsedTime time = new ElapsedTime();
    private int speed = 1999;
    private int refreshDelay = 100;

    public Engine() {
        this.timer = new Timer(refreshDelay, this);
        this.timer.addActionListener(this);
    }

    public void addStartListener(StartListener listener) {
        startListeners.add(listener);
    }

    public void addStopListener(StopListener listener) {
        stopListeners.add(listener);
    }

    public void addFinishListener(FinishListener listener) {
        finishListeners.add(listener);
    }

    public void addResetListener(ResetListener listener) {
        resetListeners.add(listener);
    }

    public void addRaceUpdateListener(RaceUpdateListener listener) {
        raceUpdateListeners.add(listener);
    }

    public void addTimeChangeListener(TimeChangeListener listener) {
        timeChangeListeners.add(listener);
    }

    public void addLoadRaceListener(LoadRaceListener listener) {
        loadRaceListeners.add(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateTime();
    }

    @Override
    public void stop() {
        LOG.debug("race stopped");
        timer.stop();
        stopListeners.forEach(StopListener::stop);
    }

    @Override
    public void reset() {
        LOG.debug("race reset");
        stop();
        updateTime(new ElapsedTime());
        resetListeners.forEach(ResetListener::reset);
    }

    @Override
    public void start() {
        LOG.debug("race started");
        timer.start();
        startListeners.forEach(StartListener::start);
    }

    @Override
    public void finish() {
        LOG.debug("race finished");
        stop();
        ElapsedTime time = raceData.getEndTime();
        updateTime(time);
        finishListeners.forEach(FinishListener::finish);
    }

    @Override
    public void refreshDelayUpdated(int delay) {
        timer.setDelay(delay);
    }

    public boolean isRunning() {
        return timer.isRunning();
    }

    public boolean isStarted() {
        return time.isAfter(new ElapsedTime());
    }

    public void loadRace(RaceData raceData) {
        this.raceData = raceData;
        loadRaceListeners.forEach(l -> l.raceLoaded(raceData));
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private void updateTime() {
        ElapsedTime newTime = time.add(speed);
        if (raceData.hasFinished(newTime)) {
            finish();
            return;
        }
        updateTime(newTime);
    }

    private void updateTime(ElapsedTime time) {
        this.time = time;
        LOG.debug("time updated " + time);
        raceData.setTime(time);
        timeChangeListeners.forEach(l -> l.timeUpdated(time));
        raceUpdateListeners.forEach(l -> l.raceUpdated(raceData));
    }

}
