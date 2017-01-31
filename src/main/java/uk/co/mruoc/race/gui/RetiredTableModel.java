package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.*;

import java.util.Arrays;
import java.util.List;

public class RetiredTableModel extends CarStatTableModel {

    private static final List<String> COLUMN_NAMES = Arrays.asList("Id", "Time", "Lap", "Distance");

    private final CarStatFormatter idFormatter = new IdFormatter();
    private final CarStatFormatter retiredTimeFormatter = new RetiredTimeFormatter();
    private final CarStatFormatter retiredLapNumberFormatter = new RetiredLapNumberFormatter();
    private final CarStatFormatter retiredDistanceFormatter = new RetiredDistanceFormatter();

    public RetiredTableModel() {
        super(COLUMN_NAMES);
    }

    @Override
    public Object getValueAt(CarStats stats, int columnIndex) {
        switch (columnIndex) {
            case 0: return idFormatter.format(stats);
            case 1: return retiredTimeFormatter.format(stats);
            case 2: return retiredLapNumberFormatter.format(stats);
            default: return retiredDistanceFormatter.format(stats);
        }
    }

}
