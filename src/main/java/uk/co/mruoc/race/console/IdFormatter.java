package uk.co.mruoc.race.console;

import uk.co.mruoc.race.model.CarStatFormatter;
import uk.co.mruoc.race.model.CarStats;

public class IdFormatter implements CarStatFormatter {

    @Override
    public String format(CarStats stats) {
        return Integer.toString(stats.getCarId());
    }

}
