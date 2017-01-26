package uk.co.mruoc.race.core;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class LapNumberFormatterTest {

    private final CarStats stats = mock(CarStats.class);

    private final CarStatFormatter formatter = new LapNumberFormatter();

    @Test
    public void shouldFormatLapNumber() {
        int lapNumber = 5;
        given(stats.getLapNumber()).willReturn(lapNumber);

        assertThat(formatter.format(stats)).isEqualTo(Integer.toString(lapNumber));
    }

}
