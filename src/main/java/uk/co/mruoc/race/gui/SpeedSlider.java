package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpeedSlider extends JSlider implements ChangeListener, SpeedUpdateListener {

    private static final int MIN_SPEED = 1;
    private static final int MAX_SPEED = 16999;

    private final Engine engine;

    public SpeedSlider(Engine engine) {
        super(MIN_SPEED, MAX_SPEED);

        this.engine = engine;
        engine.addSpeedUpdateListener(this);

        addChangeListener(this);
        setValue(engine.getSpeed());
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (getValueIsAdjusting())
            return;
        int speed = getValue();
        engine.setSpeed(speed);
    }

    @Override
    public void speedUpdated(int speed) {
        setValue(speed);
    }

}
