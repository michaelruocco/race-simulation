package uk.co.mruoc.race.model;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.RoundingMode.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SpeedConverterTest {

    private final SpeedConverter converter = new SpeedConverter();

    @Test
    public void shouldConvertSpeedFromMetersPerMillisecondToKmPerHour1() {
        BigDecimal speedInMetersPerMillisecond = BigDecimal.valueOf(0.028);
        BigDecimal expectedSpeedInKmPerHour = BigDecimal.valueOf(100.8).setScale(3, HALF_UP);

        BigDecimal result = converter.metersPerMilliToKmPerHour(speedInMetersPerMillisecond);

        assertThat(result).isEqualTo(expectedSpeedInKmPerHour);
    }

    @Test
    public void shouldConvertSpeedFromMetersPerMillisecondToKmPerHour2() {
        BigDecimal speedInMetersPerMillisecond = BigDecimal.valueOf(0.01389);
        BigDecimal expectedSpeedInKmPerHour = BigDecimal.valueOf(50.00400).setScale(5, HALF_UP);

        BigDecimal result = converter.metersPerMilliToKmPerHour(speedInMetersPerMillisecond);

        assertThat(result).isEqualTo(expectedSpeedInKmPerHour);
    }

    @Test
    public void shouldConvertSpeedToZeroIfValueIsNull() {
        assertThat(converter.metersPerMilliToKmPerHour(null)).isEqualTo(BigDecimal.ZERO);
    }

}
