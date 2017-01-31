package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStatFormatter;
import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.IdFormatter;
import uk.co.mruoc.race.core.MaxAverageLapSpeedFormatter;

import java.util.Arrays;
import java.util.List;

public class MaximumAverageLapSpeedTableModel extends AbstractCarStatTableModel {

    private static final List<String> COLUMN_NAMES = Arrays.asList("Max Average Lap Speed", "Id");

    private final CarStatFormatter maxAverageLapSpeedFormatter = new MaxAverageLapSpeedFormatter();
    private final CarStatFormatter idFormatter = new IdFormatter();

    public MaximumAverageLapSpeedTableModel() {
        super(COLUMN_NAMES);
    }

    @Override
    public Object getValueAt(CarStats stats, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return maxAverageLapSpeedFormatter.format(stats);
            default:
                return idFormatter.format(stats);
        }
    }

}
