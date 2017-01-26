package uk.co.mruoc.race.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static uk.co.mruoc.race.model.CarStatFormatter.NOT_APPLICABLE;

public class MaxAverageLapSpeedFormatterTest {

    private final CarStats stats = mock(CarStats.class);

    private final CarStatFormatter formatter = new MaxAverageLapSpeedFormatter();

    @Test
    public void shouldReturnNotApplicableIfNotCompletedOneLap() {
        given(stats.getLapNumber()).willReturn(0);

        assertThat(formatter.format(stats)).isEqualTo(NOT_APPLICABLE);
    }

    @Test
    public void shouldConvertFromMetersPerMilliToKmPerHourAndFormatMaxAverageLapSpeed() {
        BigDecimal maxAverageLapSpeed = BigDecimal.valueOf(0.05);
        given(stats.getLapNumber()).willReturn(1);
        given(stats.getMaximumAverageLapSpeed()).willReturn(maxAverageLapSpeed);

        assertThat(formatter.format(stats)).isEqualTo("180.00");
    }

}
