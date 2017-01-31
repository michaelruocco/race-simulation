package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import java.util.Collection;

public class RefreshSlider extends JSlider implements ChangeListener, RefreshDelayUpdateListener {

    private static final int MIN_DELAY = 50;
    private static final int MAX_DELAY = 250;
    private static final int DEFAULT_REFRESH_DELAY = 100;

    private final Collection<RefreshDelayUpdateListener> listeners = new ArrayList<>();

    public RefreshSlider() {
        super(MIN_DELAY, MAX_DELAY);

        setInverted(true);
        addChangeListener(this);
        setValue(DEFAULT_REFRESH_DELAY);
    }

    public void addRefreshDelayUpdateListener(RefreshDelayUpdateListener listener) {
        listener.refreshDelayUpdated(getValue());
        listeners.add(listener);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (getValueIsAdjusting())
            return;
        int delay = getValue();
        listeners.forEach(l -> l.refreshDelayUpdated(delay));
    }

    @Override
    public void refreshDelayUpdated(int delay) {
        setValue(delay);
    }

}
