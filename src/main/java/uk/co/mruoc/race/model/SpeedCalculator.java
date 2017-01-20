package uk.co.mruoc.race.model;

import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;
import static java.math.MathContext.*;

public class SpeedCalculator {

    public BigDecimal calculate(BigDecimal distance, ElapsedTime time) {
        BigDecimal totalMillis = valueOf(time.getTotalMillis());
        if (totalMillis.equals(ZERO))
            return ZERO;
        return distance.divide(totalMillis, DECIMAL32);
    }

}
