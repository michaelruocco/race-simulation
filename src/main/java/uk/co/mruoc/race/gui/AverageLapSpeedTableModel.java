package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.AverageLapSpeedFormatter;
import uk.co.mruoc.race.core.CarStatFormatter;
import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.IdFormatter;

import java.util.Arrays;
import java.util.List;

public class AverageLapSpeedTableModel extends AbstractCarStatTableModel {

    private static final List<String> COLUMN_NAMES = Arrays.asList("Average Lap Speed", "Id");

    private final CarStatFormatter averageLapSpeedFormatter = new AverageLapSpeedFormatter();
    private final CarStatFormatter idFormatter = new IdFormatter();

    public AverageLapSpeedTableModel() {
        super(COLUMN_NAMES);
    }

    @Override
    public Object getValueAt(CarStats stats, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return averageLapSpeedFormatter.format(stats);
            default:
                return idFormatter.format(stats);
        }
    }

}
