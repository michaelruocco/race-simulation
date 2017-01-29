package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RefreshSlider extends JSlider implements ChangeListener, RefreshDelayUpdateListener {

    private static final int MIN_DELAY = 50;
    private static final int MAX_DELAY = 250;

    private final Engine engine;

    public RefreshSlider(Engine engine) {
        super(MIN_DELAY, MAX_DELAY);

        this.engine = engine;
        engine.addRefreshDelayUpdateListener(this);

        setInverted(true);
        addChangeListener(this);
        setValue(engine.getRefreshDelay());
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (getValueIsAdjusting())
            return;
        int delay = getValue();
        engine.setRefreshDelay(delay);
    }

    @Override
    public void refreshDelayUpdated(int delay) {
        setValue(delay);
    }

}
