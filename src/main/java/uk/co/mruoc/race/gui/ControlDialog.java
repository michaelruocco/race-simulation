package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class ControlDialog {

    private final JLabel speedLabel = new JLabel("Speed");
    private final JLabel refreshLabel = new JLabel("Refresh Rate");

    private final JSlider speedSlider;
    private final JSlider refreshSlider;
    private final List<JComponent> components;
    private final JFrame window;

    public ControlDialog(ControlActions controlActions, JFrame window) {
        speedSlider = controlActions.getSpeedSlider();
        refreshSlider = controlActions.getRefreshSlider();
        components = Arrays.asList(speedLabel, speedSlider, refreshLabel, refreshSlider);
        this.window = window;
    }

    public void show() {
        showMessageDialog(window, components.toArray(), "Control", PLAIN_MESSAGE);
    }

}
