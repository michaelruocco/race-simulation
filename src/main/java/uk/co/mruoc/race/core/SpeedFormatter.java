package uk.co.mruoc.race.core;

import java.math.BigDecimal;

public class SpeedFormatter implements CarStatFormatter {

    private final SpeedConverter speedConverter = new SpeedConverter();

    @Override
    public String format(CarStats stats) {
        if (stats.hasRetired())
            return NOT_APPLICABLE;
        return formatSpeed(stats.getSpeed());
    }

    private String formatSpeed(BigDecimal speed) {
        return format(speedConverter.metersPerMilliToKmPerHour(speed));
    }

}
