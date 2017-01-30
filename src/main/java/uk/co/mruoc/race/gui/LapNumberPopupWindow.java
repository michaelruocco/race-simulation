package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.IdFormatter;
import uk.co.mruoc.race.core.LapNumberFormatter;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class LapNumberPopupWindow extends PopupWindow {

    public LapNumberPopupWindow(Engine engine) {
        super(new LapTable(engine));
        setTitle("Lap Number");
        setPreferredSize(new Dimension(200, 200));
        pack();
    }

    private static class LapTable extends CarStatTable {

        public LapTable(Engine engine) {
            super(new LapTableModel(engine), engine);
        }

    }

    private static class LapTableModel extends AbstractCarStatTableModel {

        private static final List<String> COLUMN_NAMES = Arrays.asList("Lap", "Id");

        private final LapNumberFormatter lapNumberFormatter = new LapNumberFormatter();
        private final IdFormatter idFormatter = new IdFormatter();

        public LapTableModel(Engine engine) {
            super(COLUMN_NAMES, engine);
        }

        @Override
        public Object getValueAt(CarStats stats, int columnIndex) {
            switch(columnIndex) {
                case 0: return lapNumberFormatter.format(stats);
                default: return idFormatter.format(stats);
            }
        }

    }

}
