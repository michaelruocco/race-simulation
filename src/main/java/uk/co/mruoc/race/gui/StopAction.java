package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class StopAction extends RaceAction implements StartListener, StopListener {

    private final ImageIcon smallIcon = loadIcon("/toolbarButtonGraphics/media/Pause16.gif");
    private final ImageIcon largeIcon = loadIcon("/toolbarButtonGraphics/media/Pause24.gif");

    private final Engine engine;

    public StopAction(Engine engine) {
        setLargeIcon(largeIcon);
        setSmallIcon(smallIcon);
        setText("Stop");
        setEnabled(engine.isRunning());

        engine.addStartListener(this);
        engine.addStopListener(this);

        this.engine = engine;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        engine.stop();
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
