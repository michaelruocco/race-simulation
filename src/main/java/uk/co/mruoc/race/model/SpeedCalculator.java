package uk.co.mruoc.race.model;

import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;
import java.math.MathContext;

public class SpeedCalculator {

    public static BigDecimal calculate(BigDecimal distance, ElapsedTime time) {
        return distance.divide(BigDecimal.valueOf(time.getTotalMillis()), MathContext.DECIMAL32);
    }

}
