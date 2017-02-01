package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.*;

import java.util.Iterator;

public class StatusPanelHtmlBuilder implements HtmlBuilder {

    private final CarStatFormatter idFormatter = new IdFormatter();
    private final CarStatFormatter positionFormatter = new PositionFormatter();
    private final CarStatFormatter lapNumberFormatter = new LapNumberFormatter();
    private final CarStatFormatter speedFormatter = new SpeedFormatter();
    private final CarStatFormatter timeDifferenceFormatter = new TimeDifferenceFormatter();

    private final String template;

    public StatusPanelHtmlBuilder() {
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
                "<th class=\"column\">Pos</th>" +
                "<th class=\"column\">Id</th>" +
                "<th class=\"speedColumn\">Speed</th>" +
                "<th class=\"column\">Lap</th>" +
                "<th class=\"timeColumn\">Time Diff</th>" +
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
                "</tr>";
    }

}
