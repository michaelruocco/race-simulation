package uk.co.mruoc.race.console;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.lang3.StringUtils;
import uk.co.mruoc.race.model.CarStats;
import uk.co.mruoc.race.model.RaceData;
import uk.co.mruoc.time.ElapsedTime;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConsoleReportBuilder {

    private static final char COLUMN_SEPARATOR = '|';
    private static final char ROW_SEPARATOR = '-';
    private static final String NEW_LINE = System.lineSeparator();

    private final Columns columns = new Columns();
    private final CarStatsToLineConverter statsToLineConverter = new CarStatsToLineConverter(columns);
    private StringBuilder report;

    private static final List<String> COLUMN_HEADERS = Arrays.asList(
            " Position ",
            " ID ",
            " Speed ",
            " Lap Number ",
            " Time Difference ",
            " Average Lap Speed ",
            " Max Average Lap Speed ",
            " Pit Time ",
            " Pit Lap "
    );

    public String build(RaceData raceData) {
        report = new StringBuilder();
        Iterator<ElapsedTime> queryTimes = raceData.getQueryTimes();
        while (queryTimes.hasNext()) {
            ElapsedTime queryTime = queryTimes.next();
            raceData.setTime(queryTime);
            appendReport(raceData.getCarStats());
        }
        return report.toString();
    }

    private void appendReport(Iterator<CarStats> stats) {
        appendNewLine();
        appendRowLine();
        appendHeader();
        appendHeaderSeparator();
        appendLines(stats);
        appendRowLine();
        appendNewLine();
        appendNewLine();
    }

    private void appendRowLine() {
        int width = getRowWidth();
        appendHeaderSeparator(width);
    }

    private int getRowWidth() {
        int columnCount = COLUMN_HEADERS.size();
        int rowWidth = 0;
        for (int c = 0; c < columnCount; c++)
            rowWidth += getColumnWidth(c) + 1;
        return rowWidth + 1;
    }

    private int getColumnWidth(int columnIndex) {
        String header = COLUMN_HEADERS.get(columnIndex);
        return header.length();
    }

    private void appendHeader() {
        appendNewLine();
        appendColumnSeparator();
        for (String columnHeader : COLUMN_HEADERS) {
            report.append(columnHeader);
            appendColumnSeparator();
        }
    }

    private void appendHeaderSeparator() {
        appendNewLine();
        appendColumnSeparator();
        for (String columnHeader : COLUMN_HEADERS) {
            appendHeaderSeparator(columnHeader.length());
            appendColumnSeparator();
        }
    }

    private void appendHeaderSeparator(int width) {
        report.append(StringUtils.repeat(ROW_SEPARATOR, width));
    }

    private void appendLines(Iterator<CarStats> carStatsIterator) {
        while (carStatsIterator.hasNext())
            appendLine(carStatsIterator.next());
        appendNewLine();
    }

    private void appendLine(CarStats stats) {
        report.append(NEW_LINE);
        report.append(statsToLineConverter.toLine(stats));
    }

    private void appendNewLine() {
        report.append(NEW_LINE);
    }

    private void appendColumnSeparator() {
        report.append(COLUMN_SEPARATOR);
    }

}
