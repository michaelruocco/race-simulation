package uk.co.mruoc.race.console;

import uk.co.mruoc.race.core.IdFormatter;
import uk.co.mruoc.race.core.RetiredDistanceFormatter;
import uk.co.mruoc.race.core.RetiredLapNumberFormatter;
import uk.co.mruoc.race.core.RetiredTimeFormatter;

import java.util.ArrayList;
import java.util.List;

public class RetiredColumns extends Columns {

    public RetiredColumns(String rowSeparator) {
        super(buildColumns(), rowSeparator);
    }

    private static List<Column> buildColumns() {
        List<Column> columns = new ArrayList<>();
        columns.add(new Column(" ID ", new IdFormatter()));
        columns.add(new Column(" Retired Time ", new RetiredTimeFormatter()));
        columns.add(new Column(" Retired Lap ", new RetiredLapNumberFormatter()));
        columns.add(new Column(" Retired Distance ", new RetiredDistanceFormatter()));
        return columns;
    }

}
