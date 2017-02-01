package uk.co.mruoc.race.core;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public interface CarStatFormatter {

    String NOT_APPLICABLE = "-";

    String format(CarStats stats);

    default String format(BigDecimal value) {
        return value.setScale(2, HALF_UP).toString();
    }

}
