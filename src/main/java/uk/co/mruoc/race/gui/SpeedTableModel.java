package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStatFormatter;
import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.IdFormatter;
import uk.co.mruoc.race.core.SpeedFormatter;

import java.util.Arrays;
import java.util.List;

public class SpeedTableModel extends AbstractCarStatTableModel {

    private static final List<String> COLUMN_NAMES = Arrays.asList("Speed", "Id");

    private final CarStatFormatter speedFormatter = new SpeedFormatter();
    private final CarStatFormatter idFormatter = new IdFormatter();

    public SpeedTableModel() {
        super(COLUMN_NAMES);
    }

    @Override
    public Object getValueAt(CarStats stats, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return speedFormatter.format(stats);
            default:
                return idFormatter.format(stats);
        }
    }

}
