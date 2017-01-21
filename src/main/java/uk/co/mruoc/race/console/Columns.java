package uk.co.mruoc.race.console;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Columns implements Iterable<String> {

    private static final List<String> headers = buildHeaders();
    private final char separator = '|';

    public int size() {
        return headers.size();
    }

    @Override
    public Iterator<String> iterator() {
        return headers.iterator();
    }

    public String getHeader(int index) {
        return headers.get(index);
    }

    public int getWidth(int index) {
        String header = getHeader(index);
        return header.length();
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
