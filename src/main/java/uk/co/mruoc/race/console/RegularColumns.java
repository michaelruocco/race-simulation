package uk.co.mruoc.race.console;

import uk.co.mruoc.race.core.IdFormatter;
import uk.co.mruoc.race.core.*;

import java.util.ArrayList;
import java.util.List;

public class RegularColumns extends Columns {

    public RegularColumns(String rowSeparator) {
        super(buildColumns(), rowSeparator);
    }

    private static List<Column> buildColumns() {
        List<Column> columns = new ArrayList<>();
        columns.add(new Column(" Position ", new PositionFormatter()));
        columns.add(new Column(" ID ", new IdFormatter()));
        columns.add(new Column(" Speed ", new SpeedFormatter()));
        columns.add(new Column(" Lap Number ", new LapNumberFormatter()));
        columns.add(new Column(" Time Difference ", new TimeDifferenceFormatter()));
        columns.add(new Column(" Average Lap Speed ", new AverageLapSpeedFormatter()));
        columns.add(new Column(" Max Average Lap Speed ", new MaxAverageLapSpeedFormatter()));
        columns.add(new Column("   Pit Time   ", new PitTimeFormatter()));
        columns.add(new Column(" Pit Lap ", new PitLapNumberFormatter()));
        return columns;
    }

}
