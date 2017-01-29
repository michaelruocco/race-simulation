package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.IdFormatter;
import uk.co.mruoc.race.core.PositionFormatter;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class PositionPopupWindow extends StatPopupWindow {

    public PositionPopupWindow(Engine engine) {
        super(new PositionTable(engine));
        setTitle("Position");
        setPreferredSize(new Dimension(200, 200));
        pack();
    }

    private static class PositionTable extends CarStatTable {

        public PositionTable(Engine engine) {
            super(new PositionTableModel(engine), engine);
        }

    }

    private static class PositionTableModel extends AbstractCarStatTableModel {

        private static final List<String> COLUMN_NAMES = Arrays.asList("Position", "Id");

        private final IdFormatter idFormatter = new IdFormatter();
        private final PositionFormatter positionFormatter = new PositionFormatter();

        public PositionTableModel(Engine engine) {
            super(COLUMN_NAMES, engine);
        }

        @Override
        public Object getValueAt(CarStats stats, int columnIndex) {
            switch(columnIndex) {
                case 0: return positionFormatter.format(stats);
                default: return idFormatter.format(stats);
            }
        }

    }

}
