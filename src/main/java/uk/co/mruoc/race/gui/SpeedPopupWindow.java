package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.IdFormatter;
import uk.co.mruoc.race.core.SpeedFormatter;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class SpeedPopupWindow extends PopupWindow {

    public SpeedPopupWindow(Engine engine) {
        super(new SpeedTable(engine));
        setTitle("Speed");
        setPreferredSize(new Dimension(200, 200));
        pack();
    }

    private static class SpeedTable extends CarStatTable {

        public SpeedTable(Engine engine) {
            super(new SpeedTableModel(engine), engine);
        }

    }

    private static class SpeedTableModel extends AbstractCarStatTableModel {

        private static final List<String> COLUMN_NAMES = Arrays.asList("Speed", "Id");

        private final SpeedFormatter speedFormatter = new SpeedFormatter();
        private final IdFormatter idFormatter = new IdFormatter();

        public SpeedTableModel(Engine race) {
            super(COLUMN_NAMES, race);
        }

        @Override
        public Object getValueAt(CarStats stats, int columnIndex) {
            switch(columnIndex) {
                case 0: return speedFormatter.format(stats);
                default: return idFormatter.format(stats);
            }
        }

    }

}
