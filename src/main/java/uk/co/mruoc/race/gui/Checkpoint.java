package uk.co.mruoc.race.gui;

import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

public class Checkpoint {

    private final int id;
    private final BigDecimal location;

    public Checkpoint(int id, BigDecimal location) {
        this.id = id;
        this.location = location;
    }

    public int calculateIndex(List<Point> points) {
        int index = location.multiply(BigDecimal.valueOf(points.size())).intValue();
        return Math.min(index, points.size() - 1);
    }

    public int getId() {
        return id;
    }

}
