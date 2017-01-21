package uk.co.mruoc.race.console;

import org.apache.commons.lang3.StringUtils;
import uk.co.mruoc.race.model.CarStats;

import java.util.Iterator;

public class SingleReportBuilder {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String ROW_SEPARATOR = "-";

    private final Columns columns;
    private final CarStatsToLineConverter statsToLineConverter;

    public SingleReportBuilder(Columns columns) {
        this.columns = columns;
        this.statsToLineConverter = new CarStatsToLineConverter(columns);
    }

    public String build(Iterator<CarStats> stats) {
        StringBuilder report = new StringBuilder();
        report.append(NEW_LINE);
        report.append(StringUtils.repeat(ROW_SEPARATOR, columns.getTotalWidth()));
        report.append(NEW_LINE);
        report.append(columns.getHeaderRow());
        report.append(NEW_LINE);
        report.append(columns.getHeaderSeparatorRow());
        while (stats.hasNext()) {
            report.append(NEW_LINE);
            report.append(statsToLineConverter.toLine(stats.next()));
        }
        report.append(NEW_LINE);
        report.append(StringUtils.repeat(ROW_SEPARATOR, columns.getTotalWidth()));
        return report.toString();
    }

}
