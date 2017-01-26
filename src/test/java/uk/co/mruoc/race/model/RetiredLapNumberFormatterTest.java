package uk.co.mruoc.race.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static uk.co.mruoc.race.model.CarStatFormatter.NOT_APPLICABLE;

public class RetiredLapNumberFormatterTest {

    private final CarStats stats = mock(CarStats.class);

    private final CarStatFormatter formatter = new RetiredLapNumberFormatter();

    @Test
    public void shouldReturnNotApplicableIfNotRetired() {
        assertThat(formatter.format(stats)).isEqualTo(NOT_APPLICABLE);
    }

    @Test
    public void shouldFormatRetiredLapNumberIfRetired() {
        int lapNumber = 4;
        given(stats.hasRetired()).willReturn(true);
        given(stats.getLapNumber()).willReturn(lapNumber);

        assertThat(formatter.format(stats)).isEqualTo(Integer.toString(lapNumber));
    }

}
