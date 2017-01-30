package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.AverageLapSpeedFormatter;
import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.IdFormatter;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class AverageLapSpeedPopupWindow extends PopupWindow {

    public AverageLapSpeedPopupWindow(Engine engine) {
        super(new Table(engine));
        setTitle("Average Lap Speed");
        setPreferredSize(new Dimension(250, 200));
        pack();
    }

    private static class Table extends CarStatTable {

        public Table(Engine engine) {
            super(new TableModel(engine), engine);
        }

    }

    private static class TableModel extends AbstractCarStatTableModel {

        private static final List<String> COLUMN_NAMES = Arrays.asList("Average Lap Speed", "Id");

        private final AverageLapSpeedFormatter averageLapSpeedFormatter = new AverageLapSpeedFormatter();
        private final IdFormatter idFormatter = new IdFormatter();

        public TableModel(Engine engine) {
            super(COLUMN_NAMES, engine);
        }

        @Override
        public Object getValueAt(CarStats stats, int columnIndex) {
            switch(columnIndex) {
                case 0: return averageLapSpeedFormatter.format(stats);
                default: return idFormatter.format(stats);
            }
        }

    }

}
