package uk.co.mruoc.race.gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CssRules implements Iterable<String> {

    private final CarToColorConverter colorConverter = new CarToColorConverter();
    private final List<String> rules = new ArrayList<>();

    public CssRules(List<Integer> ids) {
        rules.add("body { font-family:Arial; font-size:x-small; }");
        rules.add("table, th, td { text-align:center;}");
        rules.add("table { border-collapse:collapse; border-spacing:0pt; }");
        rules.add("th { background-color:#cccccc; color:black; border:1px solid black; border-left:none; border-right:none; text-align:center;}");
        rules.add("td { font-weight:bold; border-bottom:1px solid black; }");
        rules.add(".column { width:25px; }");
        rules.add(".speedColumn { width:30px; }");
        rules.add(".timeColumn { width:55px; }");
        rules.add(".wideColumn { width:70px; }");
        ids.forEach(id -> rules.add(toCarRule(id)));
    }

    @Override
    public Iterator<String> iterator() {
        return rules.iterator();
    }

    private String toCarRule(int id) {
        return ".car" + id + " {color: " + toHexColor(id) + ";}";
    }

    private String toHexColor(int id) {
        return colorConverter.toHex(id);
    }

}
