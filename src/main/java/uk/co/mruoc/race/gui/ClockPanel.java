package uk.co.mruoc.race.gui;

import uk.co.mruoc.time.ElapsedTime;

import javax.swing.*;
import java.awt.*;

public class ClockPanel extends JPanel implements TimeChangeListener {

    private final AnalogClock analogClock;
    private final TextClock textClock;

    public ClockPanel() {
        this.analogClock = new AnalogClock();
        this.textClock = new TextClock();

        setLayout(new BorderLayout());
        add(analogClock, BorderLayout.CENTER);
        add(textClock, BorderLayout.SOUTH);
    }

    @Override
    public void timeUpdated(ElapsedTime time) {
        analogClock.update(time);
        textClock.update(time);
    }

}
