package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.RaceData;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CarTableCellRenderer extends DefaultTableCellRenderer implements LoadRaceListener {

    private static final CarColorToConverter CAR_COLOR_TO_CONVERTER = new CarColorToConverter();
    private RaceData raceData;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        CarStats stats = getCarStats(row);
        c.setFont(c.getFont().deriveFont(Font.BOLD));
        c.setForeground(CAR_COLOR_TO_CONVERTER.toColor(stats.getCarId()));
        System.out.println(c.getForeground());
        return c;
    }

    @Override
    public void raceLoaded(RaceData raceData) {
        this.raceData = raceData;
    }

    private CarStats getCarStats(int row) {
        return raceData.getCarStatsByIndex(row);
    }

}
