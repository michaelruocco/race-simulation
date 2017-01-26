package uk.co.mruoc.race.core;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static uk.co.mruoc.race.core.CarStatFormatter.NOT_APPLICABLE;

public class PitTimeFormatterTest {

    private final CarStats stats = mock(CarStats.class);

    private final CarStatFormatter formatter = new PitTimeFormatter();

    @Test
    public void shouldReturnNotApplicableIfNotPitted() {
        assertThat(formatter.format(stats)).isEqualTo(NOT_APPLICABLE);
    }

    @Test
    public void shouldFormatLapNumberIfPitted() {
        ElapsedTime pitTime = new ElapsedTime();
        given(stats.hasPitted()).willReturn(true);
        given(stats.getPitTime()).willReturn(pitTime);

        assertThat(formatter.format(stats)).isEqualTo(pitTime.toString());
    }

}
