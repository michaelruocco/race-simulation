package uk.co.mruoc.race.console;

import org.apache.commons.lang3.StringUtils;
import uk.co.mruoc.race.model.CarStats;
import uk.co.mruoc.race.model.RaceData;
//import uk.co.mruoc.race.model.SpeedConverter;
import uk.co.mruoc.time.ElapsedTime;

import java.util.Iterator;

public class ConsoleReportBuilder {

    private static final String NEW_LINE = System.lineSeparator();

    //private final SpeedConverter speedConverter = new SpeedConverter();
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
        report.append(StringUtils.leftPad(Integer.toString(stats.getPosition()), 10, ' '));
        report.append("|");
        report.append(StringUtils.leftPad(Integer.toString(stats.getCarId()), 4, ' '));
        report.append("|");
        report.append(NEW_LINE);
    }

}
