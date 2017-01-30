package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.*;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class RetiredPopupWindow extends PopupWindow {

    public RetiredPopupWindow(Engine engine) {
        super(new Table(engine));
        setTitle("Retired");
        setPreferredSize(new Dimension(400, 200));
        pack();
    }

    private static class Table extends CarStatTable {

        public Table(Engine engine) {
            super(new TableModel(engine), engine);
        }

    }

    private static class TableModel extends AbstractCarStatTableModel {

        private static final List<String> COLUMN_NAMES = Arrays.asList("Id", "Time", "Lap", "Distance");

        private final IdFormatter idFormatter = new IdFormatter();
        private final RetiredTimeFormatter retiredTimeFormatter = new RetiredTimeFormatter();
        private final LapNumberFormatter lapNumberFormatter = new LapNumberFormatter();
        private final RetiredDistanceFormatter retiredDistanceFormatter = new RetiredDistanceFormatter();

        public TableModel(Engine engine) {
            super(COLUMN_NAMES, engine);
        }

        @Override
        public Object getValueAt(CarStats stats, int columnIndex) {
            switch (columnIndex) {
                case 0: return idFormatter.format(stats);
                case 1: return retiredTimeFormatter.format(stats);
                case 2: return lapNumberFormatter.format(stats);
                default: return retiredDistanceFormatter.format(stats);
            }
        }

    }

}
