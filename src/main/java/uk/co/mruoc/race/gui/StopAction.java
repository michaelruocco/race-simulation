package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.RaceData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class StopAction extends RaceAction implements StartListener, StopListener, FinishListener, LoadRaceListener {

    private final ImageIcon smallIcon = loadIcon("/toolbarButtonGraphics/media/Pause16.gif");
    private final ImageIcon largeIcon = loadIcon("/toolbarButtonGraphics/media/Pause24.gif");

    private Collection<StopListener> listeners = new ArrayList<>();

    public StopAction() {
        setLargeIcon(largeIcon);
        setSmallIcon(smallIcon);
        setText("Stop");
    }

    public void addListener(StopListener listener) {
        listeners.add(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        listeners.forEach(StopListener::stop);
    }

    @Override
    public void stop() {
        setEnabled(false);
    }

    @Override
    public void start() {
        setEnabled(true);
    }

    @Override
    public void finish() {
        setEnabled(false);
    }

    @Override
    public void raceLoaded(RaceData raceData) {
        setEnabled(false);
    }

}
