package uk.co.mruoc.race.console;

import org.apache.commons.lang3.StringUtils;
import uk.co.mruoc.race.model.CarStats;
import uk.co.mruoc.race.model.CarStatFormatter;

public class Column {

    private final String header;
    private final int width;
    private final CarStatFormatter statFormatter;

    public Column(String header, CarStatFormatter statFormatter) {
        this.header = header;
        this.width = header.length();
        this.statFormatter = statFormatter;
    }

    public int getWidth() {
        return width;
    }

    public String getHeader() {
        return header;
    }

    public String formatValue(CarStats carStats) {
        return pad(statFormatter.format(carStats), width);
    }

    private String pad(String value, int size) {
        return StringUtils.leftPad(value, size, ' ');
    }

}
