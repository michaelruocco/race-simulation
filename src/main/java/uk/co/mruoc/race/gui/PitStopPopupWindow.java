package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.IdFormatter;
import uk.co.mruoc.race.core.PitLapNumberFormatter;
import uk.co.mruoc.race.core.PitTimeFormatter;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class PitStopPopupWindow extends PopupWindow {

    public PitStopPopupWindow(Engine engine) {
        super(new Table(engine));
        setTitle("Pit Stop");
        setPreferredSize(new Dimension(350, 200));
        pack();
    }

    private static class Table extends CarStatTable {

        public Table(Engine engine) {
            super(new TableModel(engine), engine);
        }

    }

    private static class TableModel extends AbstractCarStatTableModel {

        private static final List<String> COLUMN_NAMES = Arrays.asList("Id", "Time", "Lap");

        private final IdFormatter idFormatter = new IdFormatter();
        private final PitTimeFormatter pitLapTimeFormatter = new PitTimeFormatter();
        private final PitLapNumberFormatter pitLapNumberFormatter = new PitLapNumberFormatter();

        public TableModel(Engine engine) {
            super(COLUMN_NAMES, engine);
        }

        @Override
        public Object getValueAt(CarStats stats, int columnIndex) {
            switch(columnIndex) {
                case 0: return idFormatter.format(stats);
                case 1: return pitLapTimeFormatter.format(stats);
                default: return pitLapNumberFormatter.format(stats);
            }
        }

    }

}
