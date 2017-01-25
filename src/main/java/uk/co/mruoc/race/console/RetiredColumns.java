package uk.co.mruoc.race.console;

import java.util.ArrayList;
import java.util.List;

public class RetiredColumns extends Columns {

    public RetiredColumns(String rowSeparator) {
        super(buildHeaders(), rowSeparator);
    }

    private static List<String> buildHeaders() {
        List<String> headers = new ArrayList<>();
        headers.add(" ID ");
        headers.add(" Retired Time ");
        headers.add(" Retired Lap ");
        headers.add(" Retired Distance ");
        return headers;
    }

}
