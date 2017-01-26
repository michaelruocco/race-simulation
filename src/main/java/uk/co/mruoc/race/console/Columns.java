package uk.co.mruoc.race.console;

import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.List;

public class Columns implements Iterable<Column> {

    private static final String COLUMN_SEPARATOR = "|";

    private final List<Column> columns;
    private final int totalWidth;
    private final String rowSeparator;

    public Columns(List<Column> columns, String rowSeparator) {
        this.columns = columns;
        this.totalWidth = calculateTotalWidth(columns);
        this.rowSeparator = rowSeparator;
    }

    public int size() {
        return columns.size();
    }

    @Override
    public Iterator<Column> iterator() {
        return columns.iterator();
    }

    public String getHeaderRow() {
        StringBuilder row = new StringBuilder();
        row.append(COLUMN_SEPARATOR);
        for (Column column : columns) {
            row.append(column.getHeader());
            row.append(COLUMN_SEPARATOR);
        }
        return row.toString();
    }

    public String getHeaderSeparatorRow() {
        StringBuilder row = new StringBuilder();
        row.append(COLUMN_SEPARATOR);
        for (Column column : columns) {
            row.append(StringUtils.repeat(rowSeparator, column.getWidth()));
            row.append(COLUMN_SEPARATOR);
        }
        return row.toString();
    }

    public int getWidth(int index) {
        Column column = columns.get(index);
        return column.getWidth();
    }

    public String getColumnSeparator() {
        return COLUMN_SEPARATOR;
    }

    public int getTotalWidth() {
        return totalWidth;
    }

    private static int calculateTotalWidth(List<Column> columns) {
        int width = 0;
        for (Column column : columns)
            width += column.getWidth() + 1;
        return width + 1;
    }

}
