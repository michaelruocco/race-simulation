package uk.co.mruoc.race.core;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class TimeDifferenceFormatterTest {

    private final CarStats stats = mock(CarStats.class);

    private final CarStatFormatter formatter = new TimeDifferenceFormatter();

    @Test
    public void shouldReturnLeaderIfInPolePosition() {
        given(stats.getPosition()).willReturn(1);

        assertThat(formatter.format(stats)).isEqualTo("Leader");
    }
    @Test
    public void shouldFormatTimeDifference() {
        ElapsedTime timeDifference = new ElapsedTime();
        given(stats.getTimeDifference()).willReturn(timeDifference);

        assertThat(formatter.format(stats)).isEqualTo(timeDifference.toString());
    }

}
