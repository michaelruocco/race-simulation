package uk.co.mruoc.race.gui;

import javax.swing.*;

public abstract class TrackPanel extends JPanel implements LoadRaceListener, RaceUpdateListener {

    abstract void scale(ScaleParams params);

}
