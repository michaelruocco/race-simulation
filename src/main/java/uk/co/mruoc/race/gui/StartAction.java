package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class StartAction extends RaceAction implements StartListener, StopListener, FinishListener {

    private final ImageIcon smallIcon = loadIcon("/toolbarButtonGraphics/media/Play16.gif");
    private final ImageIcon largeIcon = loadIcon("/toolbarButtonGraphics/media/Play24.gif");

    private final Engine engine;

    public StartAction(Engine engine) {
        setLargeIcon(largeIcon);
        setSmallIcon(smallIcon);
        setText("Start");
        setEnabled(!engine.isRunning());

        engine.addStartListener(this);
        engine.addStopListener(this);
        engine.addFinishListener(this);

        this.engine = engine;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        engine.start();
    }

    @Override
    public void stop() {
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
