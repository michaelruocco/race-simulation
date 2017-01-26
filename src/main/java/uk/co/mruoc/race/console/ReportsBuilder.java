package uk.co.mruoc.race.console;

import uk.co.mruoc.race.model.RaceData;
import uk.co.mruoc.time.ElapsedTime;

import java.util.Iterator;

public class ReportsBuilder {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String ROW_SEPARATOR = "-";

    private final Columns columns = new RegularColumns(ROW_SEPARATOR);
    private final ReportBuilder reportBuilder = new ReportBuilder(NEW_LINE, ROW_SEPARATOR, columns);

    private final Columns retiredColumns = new RetiredColumns(ROW_SEPARATOR);
    private final ReportBuilder retiredReportBuilder = new ReportBuilder(NEW_LINE, ROW_SEPARATOR, retiredColumns);

    public String build(RaceData raceData) {
        StringBuilder report = new StringBuilder();
        Iterator<ElapsedTime> queryTimes = raceData.getQueryTimes();
        while (queryTimes.hasNext()) {
            ElapsedTime queryTime = queryTimes.next();
            raceData.setTime(queryTime);
            report.append(NEW_LINE);
            report.append(reportBuilder.build(raceData.getRegularCarStats()));
            report.append(NEW_LINE);
            report.append(NEW_LINE);
            report.append(retiredReportBuilder.build(raceData.getRetiredCarStats()));
            report.append(NEW_LINE);
            report.append(NEW_LINE);
        }
        return report.toString();
    }

}
