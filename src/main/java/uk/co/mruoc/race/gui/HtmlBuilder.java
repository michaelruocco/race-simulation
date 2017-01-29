package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.*;

import java.util.Iterator;

public class HtmlBuilder {

    private final CarStatFormatter idFormatter = new IdFormatter();
    private final CarStatFormatter positionFormatter = new PositionFormatter();
    private final CarStatFormatter lapNumberFormatter = new LapNumberFormatter();
    private final CarStatFormatter speedFormatter = new SpeedFormatter();
    private final CarStatFormatter timeDifferenceFormatter = new TimeDifferenceFormatter();

    private final String template;

    public HtmlBuilder() {
        this.template = template();
    }

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
                "<th>Pos</th>" +
                "<th>Speed</th>" +
                "<th>Lap</th>" +
                "<th>Time Diff</th>" +
                "<th>Car</th>" +
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
        String id = idFormatter.format(stats);
        return "<tr class=\"car" + id + "\">" +
                "<td>" + positionFormatter.format(stats) + "</td>" +
                "<td class=\"wider\">" + speedFormatter.format(stats) + "</td>" +
                "<td>" + lapNumberFormatter.format(stats) + "</td>" +
                "<td class=\"wider\">" + timeDifferenceFormatter.format(stats) + "</td>" +
                "<td>" + id + "</td>" +
                "</tr>";
    }

}
