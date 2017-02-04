package uk.co.mruoc.race.gui;

import java.awt.*;

public class Checkpoint {

    private final double location;
    private final int id;

    public Checkpoint(int id, double location) {
        this.id = id;
        this.location = location;
    }

    public int calculateIndex(java.util.List<Point> points) {
        return (int) ((points.size() - 1) * location);
    }

    public int getId() {
        return id;
    }

}
