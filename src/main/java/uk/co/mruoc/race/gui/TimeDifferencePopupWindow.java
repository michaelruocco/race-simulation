package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.IdFormatter;
import uk.co.mruoc.race.core.TimeDifferenceFormatter;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class TimeDifferencePopupWindow extends PopupWindow {

    public TimeDifferencePopupWindow(Engine engine) {
        super(new TimeDifferenceTable(engine));
        setTitle("Time Difference");
        setPreferredSize(new Dimension(250, 200));
        pack();
    }

    private static class TimeDifferenceTable extends CarStatTable {

        public TimeDifferenceTable(Engine engine) {
            super(new TimeDifferenceTableModel(engine), engine);
        }

    }

    private static class TimeDifferenceTableModel extends AbstractCarStatTableModel {

        private static final List<String> COLUMN_NAMES = Arrays.asList("Time Difference", "Id");

        private final IdFormatter idFormatter = new IdFormatter();
        private final TimeDifferenceFormatter timeDifferenceFormatter = new TimeDifferenceFormatter();

        public TimeDifferenceTableModel(Engine engine) {
            super(COLUMN_NAMES, engine);
        }

        @Override
        public Object getValueAt(CarStats stats, int columnIndex) {
            switch(columnIndex) {
                case 0: return timeDifferenceFormatter.format(stats);
                default: return idFormatter.format(stats);
            }
        }

    }

}
