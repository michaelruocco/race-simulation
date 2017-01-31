package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStatFormatter;
import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.IdFormatter;
import uk.co.mruoc.race.core.PositionFormatter;

import java.util.Arrays;
import java.util.List;

public class PositionTableModel extends CarStatTableModel {

    private static final List<String> COLUMN_NAMES = Arrays.asList("Position", "Id");

    private final CarStatFormatter idFormatter = new IdFormatter();
    private final CarStatFormatter positionFormatter = new PositionFormatter();

    public PositionTableModel() {
        super(COLUMN_NAMES);
    }

    @Override
    public Object getValueAt(CarStats stats, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return positionFormatter.format(stats);
            default:
                return idFormatter.format(stats);
        }
    }
    
}
