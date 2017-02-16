package uk.co.mruoc.race.gui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.co.mruoc.race.core.RaceData;
import uk.co.mruoc.time.ElapsedTime;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Engine implements ActionListener, StartListener, StopListener, ResetListener, FinishListener, LoadRaceListener, SpeedUpdateListener, RefreshDelayUpdateListener {

    private static final ElapsedTime START_TIME = new ElapsedTime();
    private static final Logger LOG = LogManager.getLogger(Engine.class);

    private final Timer timer;

    private RaceData raceData;
    private ElapsedTime time = START_TIME;
    private int speed;
    private ControlActions controlActions;

    public Engine() {
        this.timer = new Timer(0, this);
        this.timer.addActionListener(this);
    }

    public void setControlActions(ControlActions controlActions) {
        this.controlActions = controlActions;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateTime();
    }

    @Override
    public void stop() {
        LOG.debug("race stopped");
        timer.stop();
    }

    @Override
    public void reset() {
        LOG.debug("race reset");
        stop();
        updateTime(START_TIME);
    }

    @Override
    public void start() {
        LOG.debug("race started");
        timer.start();
    }

    @Override
    public void finish() {
        LOG.debug("race finished");
        stop();
        ElapsedTime time = raceData.getEndTime();
        updateTime(time);
        controlActions.finish();
    }

    @Override
    public void raceLoaded(RaceData raceData) {
        this.raceData = raceData;
        reset();
    }

    @Override
    public void speedUpdated(int speed) {
        this.speed = speed;
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
        controlActions.timeUpdated(time);
        controlActions.raceUpdated(raceData);
    }

}
