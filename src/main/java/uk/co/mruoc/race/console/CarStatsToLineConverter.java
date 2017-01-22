package uk.co.mruoc.race.console;

import org.apache.commons.lang3.StringUtils;
import uk.co.mruoc.race.model.CarStats;
import uk.co.mruoc.race.model.PitStats;

import java.util.List;

public class CarStatsToLineConverter {

    private final CarStatsFormatter statsToValuesConverter = new CarStatsFormatter();

    private final Columns columns;

    public CarStatsToLineConverter(Columns columns) {
        this.columns = columns;
    }

    public String toLine(CarStats carStats) {
        StringBuilder line = new StringBuilder();
        line.append(columns.getColumnSeparator());
        List<String> values = statsToValuesConverter.format(carStats);
        for (int c = 0; c < columns.size(); c++) {
            String value = values.get(c);
            line.append(pad(value, columns.getWidth(c)));
            line.append(columns.getColumnSeparator());
        }
        return line.toString();
    }

    private String pad(String value, int size) {
        return StringUtils.leftPad(value, size, ' ');
    }

}
