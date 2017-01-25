package uk.co.mruoc.race.console;

import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.List;

public abstract class Columns implements Iterable<String> {

    private static final String COLUMN_SEPARATOR = "|";

    private final List<String> headers;
    private final int totalWidth;
    private final String rowSeparator;

    public Columns(List<String> headers, String rowSeparator) {
        this.headers = headers;
        this.totalWidth = calculateTotalWidth(headers);
        this.rowSeparator = rowSeparator;
    }

    public int size() {
        return headers.size();
    }

    @Override
    public Iterator<String> iterator() {
        return headers.iterator();
    }

    public String getHeaderRow() {
        StringBuilder row = new StringBuilder();
        row.append(COLUMN_SEPARATOR);
        for (String header : headers) {
            row.append(header);
            row.append(COLUMN_SEPARATOR);
        }
        return row.toString();
    }

    public String getHeaderSeparatorRow() {
        StringBuilder row = new StringBuilder();
        row.append(COLUMN_SEPARATOR);
        for (String header : headers) {
            row.append(StringUtils.repeat(rowSeparator, header.length()));
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
        return totalWidth;
    }

    private String getHeader(int index) {
        return headers.get(index);
    }

    private static int calculateTotalWidth(List<String> headers) {
        int width = 0;
        for (String header : headers)
            width += header.length() + 1;
        return width + 1;
    }

}
