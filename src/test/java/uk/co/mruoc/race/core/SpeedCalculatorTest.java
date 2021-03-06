package uk.co.mruoc.race.core;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class SpeedCalculatorTest {

    private final SpeedCalculator speedCalculator = new SpeedCalculator();

    @Test
    public void shouldCalculateSpeedInMetersPerMillisecond1() {
        BigDecimal oneHundredMeters = BigDecimal.valueOf(100);
        ElapsedTime thirtySeconds = new ElapsedTime("00:00:30.000");
        BigDecimal expectedSpeed = BigDecimal.valueOf(0.003333333);

        BigDecimal speed = speedCalculator.calculate(oneHundredMeters, thirtySeconds);

        assertThat(speed).isEqualTo(expectedSpeed);
    }

    @Test
    public void shouldCalculateSpeedInMetersPerMillisecond2() {
        BigDecimal oneHundredMeters = BigDecimal.valueOf(500);
        ElapsedTime thirtySeconds = new ElapsedTime("00:01:00.000");
        BigDecimal expectedSpeed = BigDecimal.valueOf(0.008333333);

        BigDecimal speed = speedCalculator.calculate(oneHundredMeters, thirtySeconds);

        assertThat(speed).isEqualTo(expectedSpeed);
    }

}
