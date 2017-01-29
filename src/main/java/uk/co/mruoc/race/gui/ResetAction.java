package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class ResetAction extends RaceAction implements ResetListener, StartListener {

    private final ImageIcon smallIcon = loadIcon("/toolbarButtonGraphics/media/StepBack16.gif");
    private final ImageIcon largeIcon = loadIcon("/toolbarButtonGraphics/media/StepBack24.gif");

    private final Engine engine;

    public ResetAction(Engine engine) {
        setSmallIcon(smallIcon);
        setLargeIcon(largeIcon);
        setText("Reset");
        setEnabled(engine.isStarted());

        engine.addStartListener(this);
        engine.addResetListener(this);

        this.engine = engine;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        engine.reset();
    }

    @Override
    public void reset() {
        setEnabled(false);
    }

    @Override
    public void start() {
        setEnabled(true);
    }

}
