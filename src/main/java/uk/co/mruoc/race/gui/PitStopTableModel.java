package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.*;

import java.util.Arrays;
import java.util.List;

public class PitStopTableModel extends CarStatTableModel {

    private static final List<String> COLUMN_NAMES = Arrays.asList("Id", "Time", "Lap");

    private final CarStatFormatter idFormatter = new IdFormatter();
    private final CarStatFormatter pitLapTimeFormatter = new PitTimeFormatter();
    private final CarStatFormatter pitLapNumberFormatter = new PitLapNumberFormatter();

    public PitStopTableModel() {
        super(COLUMN_NAMES);
    }

    @Override
    public Object getValueAt(CarStats stats, int columnIndex) {
        switch(columnIndex) {
            case 0: return idFormatter.format(stats);
            case 1: return pitLapTimeFormatter.format(stats);
            default: return pitLapNumberFormatter.format(stats);
        }
    }

}
