package uk.co.mruoc.race.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static uk.co.mruoc.race.model.CarStatFormatter.NOT_APPLICABLE;

public class SpeedFormatterTest {

    private final CarStats stats = mock(CarStats.class);

    private final CarStatFormatter formatter = new SpeedFormatter();

    @Test
    public void shouldConvertFromMetersPerMilliToKmPerHourAndFormatSpeed() {
        BigDecimal speed = BigDecimal.valueOf(0.05);
        given(stats.getSpeed()).willReturn(speed);

        assertThat(formatter.format(stats)).isEqualTo("180.00");
    }

}
