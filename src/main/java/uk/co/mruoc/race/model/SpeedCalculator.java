package uk.co.mruoc.race.model;

import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;
import java.math.MathContext;

public class SpeedCalculator {

    public static BigDecimal calculate(BigDecimal distance, ElapsedTime time) {
        BigDecimal totalMillis = BigDecimal.valueOf(time.getTotalMillis());
        if (totalMillis.equals(BigDecimal.ZERO))
            return BigDecimal.ZERO;
        return distance.divide(totalMillis, MathContext.DECIMAL32);
    }

}
