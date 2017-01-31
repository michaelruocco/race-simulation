package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.RaceData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class ResetAction extends RaceAction implements ResetListener, StartListener, LoadRaceListener {

    private final ImageIcon smallIcon = loadIcon("/toolbarButtonGraphics/media/StepBack16.gif");
    private final ImageIcon largeIcon = loadIcon("/toolbarButtonGraphics/media/StepBack24.gif");

    private final Collection<ResetListener> listeners = new ArrayList<>();

    public ResetAction() {
        setSmallIcon(smallIcon);
        setLargeIcon(largeIcon);
        setText("Reset");
    }

    public void addListener(ResetListener listener) {
        listeners.add(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        listeners.forEach(ResetListener::reset);
    }

    @Override
    public void reset() {
        setEnabled(false);
    }

    @Override
    public void start() {
        setEnabled(true);
    }

    @Override
    public void raceLoaded(RaceData raceData) {
        setEnabled(false);
    }

}
