package uk.co.mruoc.race.console;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Columns implements Iterable<String> {

    private static final List<String> HEADERS = buildHeaders();
    private static final int TOTAL_WIDTH = calculateTotalWidth();
    private static final String COLUMN_SEPARATOR = "|";
    private static final String ROW_SEPARATOR = "-";

    public int size() {
        return HEADERS.size();
    }

    @Override
    public Iterator<String> iterator() {
        return HEADERS.iterator();
    }

    public String getHeaderRow() {
        StringBuilder row = new StringBuilder();
        row.append(COLUMN_SEPARATOR);
        for (String header : HEADERS) {
            row.append(header);
            row.append(COLUMN_SEPARATOR);
        }
        return row.toString();
    }

    public String getHeaderSeparatorRow() {
        StringBuilder row = new StringBuilder();
        row.append(COLUMN_SEPARATOR);
        for (String header : HEADERS) {
            row.append(StringUtils.repeat(ROW_SEPARATOR, header.length()));
            row.append(COLUMN_SEPARATOR);
        }
        return row.toString();
    }

    public int getWidth(int index) {
        String header = getHeader(index);
        return header.length();
    }

    public String getColumnSeparator() {
        return COLUMN_SEPARATOR;
    }

    public int getTotalWidth() {
        return TOTAL_WIDTH;
    }

    private String getHeader(int index) {
        return HEADERS.get(index);
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

    private static int calculateTotalWidth() {
        int width = 0;
        for (String header : HEADERS)
            width += header.length() + 1;
        return width + 1;
    }

}
