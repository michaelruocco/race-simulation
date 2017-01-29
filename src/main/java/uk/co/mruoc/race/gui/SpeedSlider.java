package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpeedSlider extends JSlider implements ChangeListener {

    private static final int MIN_SPEED = 1;
    private static final int MAX_SPEED = 16999;

    private final Engine engine;

    public SpeedSlider(Engine engine) {
        super(MIN_SPEED, MAX_SPEED);
        addChangeListener(this);
        this.engine = engine;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (getValueIsAdjusting())
            return;
        int speed = getValue();
        engine.setSpeed(speed);
    }

}
