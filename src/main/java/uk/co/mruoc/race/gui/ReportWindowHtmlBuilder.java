package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.*;

import java.util.Iterator;

public class ReportWindowHtmlBuilder implements HtmlBuilder {

    private final CarStatFormatter idFormatter = new IdFormatter();
    private final CarStatFormatter positionFormatter = new PositionFormatter();
    private final CarStatFormatter lapNumberFormatter = new LapNumberFormatter();
    private final CarStatFormatter speedFormatter = new SpeedFormatter();
    private final CarStatFormatter timeDifferenceFormatter = new TimeDifferenceFormatter();
    private final CarStatFormatter averageLapSpeedFormatter = new AverageLapSpeedFormatter();
    private final CarStatFormatter maximumAverageLapSpeedFormatter = new MaxAverageLapSpeedFormatter();
    private final CarStatFormatter pitTimeFormatter = new PitTimeFormatter();
    private final CarStatFormatter pitLapNumberFormatter = new PitLapNumberFormatter();
    private final CarStatFormatter retiredTimeFormatter = new RetiredTimeFormatter();
    private final CarStatFormatter retiredLapNumberFormatter = new RetiredLapNumberFormatter();
    private final CarStatFormatter retiredDistanceFormatter = new RetiredDistanceFormatter();

    private final String template;

    public ReportWindowHtmlBuilder() {
        this.template = template();
    }

    @Override
    public String build(Iterator<CarStats> carStats) {
        return String.format(template, tableBody(carStats));
    }

    private String template() {
        String html = "<html><head></head><body>";
        html += table();
        html += "</body></html>";
        return html;
    }

    private String table() {
        return "<table>" +
                tableHeader() +
                "%s" +
                "</table>";
    }

    private String tableHeader() {
        return "<thead>" +
                "<tr>" +
                "<th class=\"wideColumn\">Pos</th>" +
                "<th class=\"wideColumn\">Id</th>" +
                "<th class=\"wideColumn\">Speed</th>" +
                "<th class=\"wideColumn\">Lap</th>" +
                "<th class=\"wideColumn\">Time Difference</th>" +
                "<th class=\"wideColumn\">Average Lap Speed</th>" +
                "<th class=\"wideColumn\">Max Average Lap Speed</th>" +
                "<th class=\"wideColumn\">Pit Time</th>" +
                "<th class=\"wideColumn\">Pit Lap</th>" +
                "<th class=\"wideColumn\">Retired Time</th>" +
                "<th class=\"wideColumn\">Retired Lap</th>" +
                "<th class=\"wideColumn\">Retired Distance</th>" +
                "</tr>" +
                "</tead>";
    }

    private String tableBody(Iterator<CarStats> carStats) {
        String html = "<tbody>";
        while(carStats.hasNext())
            html += toTableRow(carStats.next());
        html += "</tbody>";
        return html;
    }

    private String toTableRow(CarStats stats) {
        return "<tr class=\"car" + stats.getCarId() + "\">" +
                "<td>" + positionFormatter.format(stats) + "</td>" +
                "<td>" + idFormatter.format(stats) + "</td>" +
                "<td>" + speedFormatter.format(stats) + "</td>" +
                "<td>" + lapNumberFormatter.format(stats) + "</td>" +
                "<td>" + timeDifferenceFormatter.format(stats) + "</td>" +
                "<td>" + averageLapSpeedFormatter.format(stats) + "</td>" +
                "<td>" + maximumAverageLapSpeedFormatter.format(stats) + "</td>" +
                "<td>" + pitTimeFormatter.format(stats) + "</td>" +
                "<td>" + pitLapNumberFormatter.format(stats) + "</td>" +
                "<td>" + retiredTimeFormatter.format(stats) + "</td>" +
                "<td>" + retiredLapNumberFormatter.format(stats) + "</td>" +
                "<td>" + retiredDistanceFormatter.format(stats) + "</td>" +
                "</tr>";
    }

}
