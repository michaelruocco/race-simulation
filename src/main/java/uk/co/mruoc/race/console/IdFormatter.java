package uk.co.mruoc.race.console;

import uk.co.mruoc.race.core.CarStatFormatter;
import uk.co.mruoc.race.core.CarStats;

public class IdFormatter implements CarStatFormatter {

    @Override
    public String format(CarStats stats) {
        return Integer.toString(stats.getCarId());
    }

}
