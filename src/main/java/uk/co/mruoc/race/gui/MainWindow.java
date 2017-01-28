package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.RaceData;

import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow(RaceData raceData) {
        super("Race Simulation");

        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
