package uk.co.mruoc.race.console;

import org.apache.commons.lang3.StringUtils;
import uk.co.mruoc.race.model.CarStats;
import uk.co.mruoc.race.model.RaceData;
import uk.co.mruoc.race.model.SpeedConverter;
import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;

public class ConsoleReportBuilder {

    private static final char COLUMN_SEPARATOR = '|';
    private static final char HEADER_SEPARATOR = '-';
    private static final String NEW_LINE = System.lineSeparator();

    private static final int POSITION_COLUMN_WIDTH = 10;
    private static final int ID_COLUMN_WIDTH = 4;
    private static final int SPEED_COLUMN_WIDTH = 7;
    private static final int LAP_NUMBER_COLUMN_WIDTH = 12;
    private static final int TIME_DIFFERENCE_COLUMN_WIDTH = 17;
    private static final int AVERAGE_LAP_SPEED_COLUMN_WIDTH = 19;

    private final SpeedConverter speedConverter = new SpeedConverter();
    private StringBuilder report;

    public String build(RaceData raceData) {
        report = new StringBuilder();
        Iterator<ElapsedTime> queryTimes = raceData.getQueryTimes();
        while (queryTimes.hasNext()) {
            ElapsedTime queryTime = queryTimes.next();
            raceData.setTime(queryTime);
            appendHeaderSeparator();
            appendHeader();
            appendHeaderSeparator();
            appendLines(raceData.getCarStats());
        }
        return report.toString();
    }

    private void appendHeader() {
        appendNewLine();
        appendColumnSeparator();
        report.append(" Position ");
        appendColumnSeparator();
        report.append(" ID ");
        appendColumnSeparator();
        report.append(" Speed ");
        appendColumnSeparator();
        report.append(" Lap Number ");
        appendColumnSeparator();
        report.append(" Time Difference ");
        appendColumnSeparator();
        report.append(" Average Lap Speed ");
        appendColumnSeparator();
        report.append(" Max Average Lap Speed ");
        appendColumnSeparator();
        report.append(" Pit Time ");
        appendColumnSeparator();
        report.append(" Pit Lap ");
        appendColumnSeparator();
    }

    private void appendHeaderSeparator() {
        appendNewLine();
        appendColumnSeparator();
        appendHeaderSeparator(POSITION_COLUMN_WIDTH);
        appendColumnSeparator();
        appendHeaderSeparator(ID_COLUMN_WIDTH);
        appendColumnSeparator();
        appendHeaderSeparator(SPEED_COLUMN_WIDTH);
        appendColumnSeparator();
        appendHeaderSeparator(LAP_NUMBER_COLUMN_WIDTH);
        appendColumnSeparator();
        appendHeaderSeparator(TIME_DIFFERENCE_COLUMN_WIDTH);
        appendColumnSeparator();
        appendHeaderSeparator(AVERAGE_LAP_SPEED_COLUMN_WIDTH);
        appendColumnSeparator();
        report.append("-----------------------");
        appendColumnSeparator();
        report.append("----------");
        appendColumnSeparator();
        report.append("---------");
        appendColumnSeparator();
    }

    private void appendLines(Iterator<CarStats> carStatsIterator) {
        while (carStatsIterator.hasNext())
            appendLine(carStatsIterator.next());
        appendNewLine();
    }

    private void appendLine(CarStats stats) {
        appendNewLine();
        appendColumnSeparator();
        report.append(pad(formatPosition(stats), POSITION_COLUMN_WIDTH));
        appendColumnSeparator();
        report.append(pad(formatCarId(stats), ID_COLUMN_WIDTH));
        appendColumnSeparator();
        report.append(pad(formatSpeed(stats), SPEED_COLUMN_WIDTH));
        appendColumnSeparator();
        report.append(pad(formatLapNumber(stats), LAP_NUMBER_COLUMN_WIDTH));
        appendColumnSeparator();
        report.append(pad(formatTimeDifference(stats), TIME_DIFFERENCE_COLUMN_WIDTH));
        appendColumnSeparator();
        report.append(pad(formatAverageLapSpeed(stats), AVERAGE_LAP_SPEED_COLUMN_WIDTH));
        appendColumnSeparator();
    }

    private void appendNewLine() {
        report.append(NEW_LINE);
    }

    private void appendColumnSeparator() {
        report.append(COLUMN_SEPARATOR);
    }

    private void appendHeaderSeparator(int size) {
        report.append(StringUtils.leftPad("", size, HEADER_SEPARATOR));
    }

    private String formatPosition(CarStats stats) {
        return Integer.toString(stats.getPosition());
    }

    private String formatCarId(CarStats stats) {
        return Integer.toString(stats.getCarId());
    }

    private String formatSpeed(CarStats stats) {
        return formatSpeed(stats.getSpeed());
    }

    private String formatAverageLapSpeed(CarStats stats) {
        return formatSpeed(stats.getAverageLapSpeed());
    }

    private String formatLapNumber(CarStats stats) {
        return Integer.toString(stats.getLapNumber());
    }

    private String formatTimeDifference(CarStats stats) {
        return stats.getTimeDifference().toString();
    }

    private String formatSpeed(BigDecimal speed) {
        return speedConverter.metersPerMilliToKmPerHour(speed).setScale(2, RoundingMode.HALF_UP).toString();
    }

    private String pad(String value, int size) {
        return StringUtils.leftPad(value, size, ' ');
    }

}
