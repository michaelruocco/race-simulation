package uk.co.mruoc.race.core;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static uk.co.mruoc.race.core.CarStatFormatter.NOT_APPLICABLE;

public class PitLapNumberFormatterTest {

    private final CarStats stats = mock(CarStats.class);

    private final CarStatFormatter formatter = new PitLapNumberFormatter();

    @Test
    public void shouldReturnNotApplicableIfNotPitted() {
        assertThat(formatter.format(stats)).isEqualTo(NOT_APPLICABLE);
    }

    @Test
    public void shouldFormatLapNumberIfPitted() {
        int lapNumber = 5;
        given(stats.hasPitted()).willReturn(true);
        given(stats.getPitLapNumber()).willReturn(lapNumber);

        assertThat(formatter.format(stats)).isEqualTo(Integer.toString(lapNumber));
    }

}
