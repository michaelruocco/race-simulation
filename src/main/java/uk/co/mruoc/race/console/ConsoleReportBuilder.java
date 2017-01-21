package uk.co.mruoc.race.console;

import uk.co.mruoc.race.model.RaceData;
import uk.co.mruoc.time.ElapsedTime;

import java.util.Iterator;

public class ConsoleReportBuilder {

    private static final String NEW_LINE = System.lineSeparator();

    private final Columns columns = new Columns();
    private final SingleReportBuilder singleReportBuilder = new SingleReportBuilder(columns);

    public String build(RaceData raceData) {
        StringBuilder report = new StringBuilder();
        Iterator<ElapsedTime> queryTimes = raceData.getQueryTimes();
        while (queryTimes.hasNext()) {
            ElapsedTime queryTime = queryTimes.next();
            raceData.setTime(queryTime);
            report.append(singleReportBuilder.build(raceData.getCarStats()));
            report.append(NEW_LINE);
            report.append(NEW_LINE);
        }
        return report.toString();
    }

}
