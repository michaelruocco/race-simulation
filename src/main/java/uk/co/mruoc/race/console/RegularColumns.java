package uk.co.mruoc.race.console;

import java.util.ArrayList;
import java.util.List;

public class RegularColumns extends Columns {

    public RegularColumns(String rowSeparator) {
        super(buildHeaders(), rowSeparator);
    }

    private static List<String> buildHeaders() {
        List<String> headers = new ArrayList<>();
        headers.add(" Position ");
        headers.add(" ID ");
        headers.add(" Speed ");
        headers.add(" Lap Number ");
        headers.add(" Time Difference ");
        headers.add(" Average Lap Speed ");
        headers.add(" Max Average Lap Speed ");
        headers.add("   Pit Time   ");
        headers.add(" Pit Lap ");
        return headers;
    }

}
