package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class ControlDialog {

    private final JLabel speedLabel = new JLabel("Speed");
    private final JLabel refreshLabel = new JLabel("Refresh Rate");

    private final List<JComponent> components;

    public ControlDialog(ControlActions controlActions) {
        JSlider speedSlider = controlActions.getDialogSpeedSlider();
        JSlider refreshSlider = controlActions.getRefreshSlider();
        components = Arrays.asList(speedLabel, speedSlider, refreshLabel, refreshSlider);
    }

    public void show(JFrame window) {
        showMessageDialog(window, components.toArray(), "Control", PLAIN_MESSAGE);
    }

}
