package uk.co.mruoc.race.model;

import java.math.BigDecimal;

public class MaxAverageLapSpeedFormatter implements CarStatFormatter {

    private final SpeedConverter speedConverter = new SpeedConverter();

    @Override
    public String format(CarStats stats) {
        if (stats.getLapNumber() < 1)
            return NOT_APPLICABLE;
        if (stats.getLapNumber() == 1 && stats.hasRetired())
            return NOT_APPLICABLE;
        return formatSpeed(stats.getMaximumAverageLapSpeed());
    }

    private String formatSpeed(BigDecimal speed) {
        return format(speedConverter.metersPerMilliToKmPerHour(speed));
    }

}
