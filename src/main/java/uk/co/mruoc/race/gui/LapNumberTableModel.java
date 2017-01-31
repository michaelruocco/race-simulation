package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.IdFormatter;
import uk.co.mruoc.race.core.LapNumberFormatter;

import java.util.Arrays;
import java.util.List;

public class LapNumberTableModel extends AbstractCarStatTableModel {

    private static final List<String> COLUMN_NAMES = Arrays.asList("Lap", "Id");

    private final LapNumberFormatter lapNumberFormatter = new LapNumberFormatter();
    private final IdFormatter idFormatter = new IdFormatter();

    public LapNumberTableModel() {
        super(COLUMN_NAMES);
    }

    @Override
    public Object getValueAt(CarStats stats, int columnIndex) {
        switch(columnIndex) {
            case 0: return lapNumberFormatter.format(stats);
            default: return idFormatter.format(stats);
        }
    }

}