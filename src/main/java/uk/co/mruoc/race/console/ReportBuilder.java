package uk.co.mruoc.race.console;

import org.apache.commons.lang3.StringUtils;
import uk.co.mruoc.race.model.CarStats;

import java.util.Iterator;

public class ReportBuilder {

    private final String newLine;
    private final String rowSeparator;
    private final Columns columns;
    private final CarStatsToLineConverter statsToLineConverter;

    public ReportBuilder(String newLine, String rowSeparator, Columns columns) {
        this.newLine = newLine;
        this.rowSeparator = rowSeparator;
        this.columns = columns;
        this.statsToLineConverter = new CarStatsToLineConverter(columns);
    }

    public String build(Iterator<CarStats> stats) {
        StringBuilder report = new StringBuilder();
        report.append(builderHeader(columns));
        while (stats.hasNext())
            report.append(buildLine(stats.next()));
        report.append(buildFooter());
        return report.toString();
    }

    private String builderHeader(Columns columns) {
        StringBuilder header = new StringBuilder();
        header.append(buildRowSeparator());
        header.append(newLine);
        header.append(columns.getHeaderRow());
        header.append(newLine);
        header.append(columns.getHeaderSeparatorRow());
        return header.toString();
    }

    private String buildLine(CarStats stats) {
        StringBuilder line = new StringBuilder();
        line.append(newLine);
        line.append(statsToLineConverter.toLine(stats));
        return line.toString();
    }

    private String buildFooter() {
        StringBuilder footer = new StringBuilder();
        footer.append(newLine);
        footer.append(buildRowSeparator());
        return footer.toString();
    }

    private String buildRowSeparator() {
        return StringUtils.repeat(rowSeparator, columns.getTotalWidth());
    }

}
