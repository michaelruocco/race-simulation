package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class StartAction extends RaceAction implements StartListener, StopListener, ResetListener, FinishListener {

    private final ImageIcon smallIcon = loadIcon("/toolbarButtonGraphics/media/Play16.gif");
    private final ImageIcon largeIcon = loadIcon("/toolbarButtonGraphics/media/Play24.gif");

    private final Collection<StartListener> listeners = new ArrayList<>();

    public StartAction() {
        setLargeIcon(largeIcon);
        setSmallIcon(smallIcon);
        setText("Start");
    }

    public void addStartListener(StartListener listener) {
        listeners.add(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        listeners.forEach(StartListener::start);
    }

    @Override
    public void stop() {
        setEnabled(true);
    }

    @Override
    public void reset() {
        setEnabled(true);
    }

    @Override
    public void start() {
        setEnabled(false);
    }

    @Override
    public void finish() {
        setEnabled(false);
    }

}
