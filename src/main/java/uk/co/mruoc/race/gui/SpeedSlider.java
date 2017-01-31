package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import java.util.Collection;

public class SpeedSlider extends JSlider implements ChangeListener, SpeedUpdateListener {

    private static final int MIN_SPEED = 1;
    private static final int MAX_SPEED = 16999;
    private static final int DEFAULT_SPEED = 1999;

    private final Collection<SpeedUpdateListener> listeners = new ArrayList<>();

    public SpeedSlider() {
        super(MIN_SPEED, MAX_SPEED);

        addChangeListener(this);
        setValue(DEFAULT_SPEED);
    }

    public void addSpeedUpdateListener(SpeedUpdateListener listener) {
        listener.speedUpdated(getValue());
        listeners.add(listener);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (getValueIsAdjusting())
            return;
        int speed = getValue();
        listeners.forEach(l -> l.speedUpdated(speed));
    }

    @Override
    public void speedUpdated(int speed) {
        setValue(speed);
    }

}
