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

    private static final String NEW_LINE = System.lineSeparator();

    private final SpeedConverter speedConverter = new SpeedConverter();
    private StringBuilder report;

    public String build(RaceData raceData) {
        report = new StringBuilder();
        Iterator<ElapsedTime> queryTimes = raceData.getQueryTimes();
        while (queryTimes.hasNext()) {
            ElapsedTime queryTime = queryTimes.next();
            raceData.setTime(queryTime);
            appendHeader();
            appendLines(raceData.getCarStats());
        }
        return report.toString();
    }

    private void appendHeader() {
        report.append(NEW_LINE);
        report.append("| Position | ID | Speed | Lap Number | Time Difference | Average Speed | Max Average Speed | Pit Time | Pit Lap |");
        report.append(NEW_LINE);
        report.append("|----------|----|-------|------------|-----------------|---------------|-------------------|----------|---------|");
        report.append(NEW_LINE);
    }

    private void appendLines(Iterator<CarStats> carStatsIterator) {
        while (carStatsIterator.hasNext()) {
            appendLine(carStatsIterator.next());
        }
        report.append(NEW_LINE);
    }

    private void appendLine(CarStats stats) {
        report.append("|");
        report.append(pad(formatPosition(stats), 10));
        report.append("|");
        report.append(pad(formatCarId(stats), 4));
        report.append("|");
        report.append(pad(formatSpeed(stats), 7));
        report.append("|");
        report.append(pad(formatLapNumber(stats), 12));
        report.append("|");
        report.append(pad(formatTimeDifference(stats), 17));
        report.append("|");
        report.append(NEW_LINE);
    }

    private String formatPosition(CarStats stats) {
        return Integer.toString(stats.getPosition());
    }

    private String formatCarId(CarStats stats) {
        return Integer.toString(stats.getCarId());
    }

    private String formatSpeed(CarStats stats) {
        BigDecimal speed = stats.getSpeed();
        return speedConverter.metersPerMilliToKmPerHour(speed).setScale(2, RoundingMode.HALF_UP).toString();
    }

    private String formatLapNumber(CarStats stats) {
        return Integer.toString(stats.getLapNumber());
    }

    private String formatTimeDifference(CarStats stats) {
        return stats.getTimeDifference().toString();
    }

    private String pad(String value, int size) {
        return StringUtils.leftPad(value, size, ' ');
    }

}
