package uk.co.mruoc.race.core;

import java.math.BigDecimal;
import java.math.MathContext;

public class SpeedConverter {

    private static final BigDecimal MILLIS_IN_HOUR = BigDecimal.valueOf(3600000);
    private static final BigDecimal METERS_IN_KM = BigDecimal.valueOf(1000);

    public BigDecimal metersPerMilliToKmPerHour(BigDecimal speedInMetersPerMilli) {
        if (speedInMetersPerMilli == null)
            return BigDecimal.ZERO;
        BigDecimal speedInMetersPerHour = speedInMetersPerMilli.multiply(MILLIS_IN_HOUR);
        return speedInMetersPerHour.divide(METERS_IN_KM, MathContext.DECIMAL32);
    }

}
