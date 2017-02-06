package uk.co.mruoc.race.gui;

import javax.swing.*;

public abstract class TrackPanel extends JPanel implements LoadRaceListener, RaceUpdateListener {

    public abstract void updateScale(double xScale, double yScale);

}
