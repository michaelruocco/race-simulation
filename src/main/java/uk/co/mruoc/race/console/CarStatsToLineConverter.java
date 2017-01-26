package uk.co.mruoc.race.console;

import uk.co.mruoc.race.model.CarStats;

public class CarStatsToLineConverter {

    private final Columns columns;

    public CarStatsToLineConverter(Columns columns) {
        this.columns = columns;
    }

    public String toLine(CarStats carStats) {
        StringBuilder line = new StringBuilder();
        line.append(columns.getColumnSeparator());
        for (Column column : columns) {
            line.append(column.formatValue(carStats));
            line.append(columns.getColumnSeparator());
        }
        return line.toString();
    }

}
