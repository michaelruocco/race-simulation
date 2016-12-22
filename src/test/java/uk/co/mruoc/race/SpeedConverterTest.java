package uk.co.mruoc.race;

import org.junit.Test;
import uk.co.mruoc.race.model.SpeedConverter;

import java.math.BigDecimal;

import static java.math.RoundingMode.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SpeedConverterTest {

    private final SpeedConverter converter = new SpeedConverter();

    @Test
    public void shouldConvertSpeedFromMetersPerMillisecondToKmPerHour1() {
        BigDecimal expectedSpeed = BigDecimal.valueOf(100.8).setScale(3, HALF_UP);
        assertThat(converter.metersPerMilliToKmPerHour(BigDecimal.valueOf(0.028))).isEqualTo(expectedSpeed);
    }

    @Test
    public void shouldConvertSpeedFromMetersPerMillisecondToKmPerHour2() {
        BigDecimal expectedSpeed = BigDecimal.valueOf(50.00400).setScale(5, HALF_UP);
        assertThat(converter.metersPerMilliToKmPerHour(BigDecimal.valueOf(0.01389))).isEqualTo(expectedSpeed);
    }

}
