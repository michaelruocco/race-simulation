package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.HashSet;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class StopAction extends RaceAction implements StartListener, StopListener {

    private final ImageIcon smallIcon = loadIcon("/toolbarButtonGraphics/media/Pause16.gif");
    private final ImageIcon largeIcon = loadIcon("/toolbarButtonGraphics/media/Pause24.gif");

    private Collection<StopListener> listeners = new HashSet<StopListener>();
    public StopAction(Engine engine) {
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

}
