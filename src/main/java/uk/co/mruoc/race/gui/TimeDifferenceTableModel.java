package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.IdFormatter;
import uk.co.mruoc.race.core.TimeDifferenceFormatter;

import java.util.Arrays;
import java.util.List;

public class TimeDifferenceTableModel extends AbstractCarStatTableModel {

    private static final List<String> COLUMN_NAMES = Arrays.asList("Time Difference", "Id");

    private final IdFormatter idFormatter = new IdFormatter();
    private final TimeDifferenceFormatter timeDifferenceFormatter = new TimeDifferenceFormatter();

    public TimeDifferenceTableModel() {
        super(COLUMN_NAMES);
    }

    @Override
    public Object getValueAt(CarStats stats, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return timeDifferenceFormatter.format(stats);
            default:
                return idFormatter.format(stats);
        }
    }

}
