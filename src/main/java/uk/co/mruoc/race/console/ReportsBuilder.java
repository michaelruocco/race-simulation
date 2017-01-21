package uk.co.mruoc.race.console;

import uk.co.mruoc.race.model.RaceData;
import uk.co.mruoc.time.ElapsedTime;

import java.util.Iterator;

public class ReportsBuilder {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String ROW_SEPARATOR = "-";

    private final ReportBuilder reportBuilder = new ReportBuilder(NEW_LINE, ROW_SEPARATOR);

    public String build(RaceData raceData) {
        StringBuilder report = new StringBuilder();
        Iterator<ElapsedTime> queryTimes = raceData.getQueryTimes();
        while (queryTimes.hasNext()) {
            ElapsedTime queryTime = queryTimes.next();
            raceData.setTime(queryTime);
            report.append(reportBuilder.build(raceData.getCarStats()));
            report.append(NEW_LINE);
            report.append(NEW_LINE);
        }
        return report.toString();
    }

}
