package uk.co.mruoc.race.console;

import org.apache.commons.lang3.StringUtils;
import uk.co.mruoc.race.model.CarStats;

import java.util.Iterator;

public class ReportBuilder {

    private static final String ROW_SEPARATOR = "-";

    private final String newLine;
    private final String rowSeparator;
    private final Columns columns;
    private final CarStatsToLineConverter statsToLineConverter;

    public ReportBuilder(String newLine) {
        this(newLine, ROW_SEPARATOR);
    }

    private ReportBuilder(String newLine, String rowSeparator) {
        this.newLine = newLine;
        this.rowSeparator = rowSeparator;
        this.columns = new RegularColumns(rowSeparator);
        this.statsToLineConverter = new CarStatsToLineConverter(columns);
    }

    public String build(Iterator<CarStats> stats) {
        StringBuilder report = new StringBuilder();
        report.append(buildRowSeparator());
        report.append(newLine);
        report.append(columns.getHeaderRow());
        report.append(newLine);
        report.append(columns.getHeaderSeparatorRow());
        while (stats.hasNext()) {
            report.append(newLine);
            report.append(statsToLineConverter.toLine(stats.next()));
        }
        report.append(newLine);
        report.append(buildRowSeparator());
        return report.toString();
    }

    private String buildRowSeparator() {
        return StringUtils.repeat(rowSeparator, columns.getTotalWidth());
    }

}
