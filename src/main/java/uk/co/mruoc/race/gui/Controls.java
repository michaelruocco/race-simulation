package uk.co.mruoc.race.gui;

import javax.swing.*;

public class Controls {

    private final RaceAction start;
    private final RaceAction stop;
    private final RaceAction reset;

    private final JSlider speedSlider;

    public Controls(Engine engine) {
        start = new StartAction(engine);
        stop = new StopAction(engine);
        reset = new ResetAction(engine);
        speedSlider = new SpeedSlider(engine);
    }

    public JButton getStartButton() {
        return new RaceButton(start);
    }

    public JButton getStopButton() {
        return new RaceButton(stop);
    }

    public JButton getResetButton() {
        return new RaceButton(reset);
    }

    public JSlider getSpeedSlider() {
        return speedSlider;
    }

}
