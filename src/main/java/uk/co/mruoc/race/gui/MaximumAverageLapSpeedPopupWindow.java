package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.IdFormatter;
import uk.co.mruoc.race.core.MaxAverageLapSpeedFormatter;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class MaximumAverageLapSpeedPopupWindow extends StatPopupWindow {

    public MaximumAverageLapSpeedPopupWindow(Engine engine) {
        super(new Table(engine));
        setTitle("Maximum Average Lap Speed");
        setPreferredSize(new Dimension(200, 200));
        pack();
    }

    private static class Table extends CarStatTable {

        public Table(Engine engine) {
            super(new TableModel(engine), engine);
        }

    }

    private static class TableModel extends AbstractCarStatTableModel {

        private static final List<String> COLUMN_NAMES = Arrays.asList("Max Average Lap Speed", "Id");

        private final MaxAverageLapSpeedFormatter maxAverageLapSpeedFormatter = new MaxAverageLapSpeedFormatter();
        private final IdFormatter idFormatter = new IdFormatter();

        public TableModel(Engine engine) {
            super(COLUMN_NAMES, engine);
        }

        @Override
        public Object getValueAt(CarStats stats, int columnIndex) {
            switch(columnIndex) {
                case 0: return maxAverageLapSpeedFormatter.format(stats);
                default: return idFormatter.format(stats);
            }
        }

    }

}
