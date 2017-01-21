package uk.co.mruoc.race.console;

import java.util.ArrayList;
import java.util.List;

public class Columns {

    private static final List<String> headers = buildHeaders();
    private final char separator = '|';

    public int size() {
        return headers.size();
    }

    public String getHeader(int index) {
        return headers.get(index);
    }

    public char getSeparator() {
        return separator;
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
        headers.add(" Pit Time ");
        headers.add(" Pit Lap ");
        return headers;
    }

}
