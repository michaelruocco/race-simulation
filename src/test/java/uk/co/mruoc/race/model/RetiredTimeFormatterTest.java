package uk.co.mruoc.race.model;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static uk.co.mruoc.race.model.CarStatFormatter.NOT_APPLICABLE;

public class RetiredTimeFormatterTest {

    private final CarStats stats = mock(CarStats.class);

    private final CarStatFormatter formatter = new RetiredTimeFormatter();

    @Test
    public void shouldReturnNotApplicableIfNotRetired() {
        assertThat(formatter.format(stats)).isEqualTo(NOT_APPLICABLE);
    }

    @Test
    public void shouldFormatRetiredTimeIfRetired() {
        ElapsedTime retiredTime = new ElapsedTime();
        given(stats.hasRetired()).willReturn(true);
        given(stats.getRetiredTime()).willReturn(retiredTime);

        assertThat(formatter.format(stats)).isEqualTo(retiredTime.toString());
    }

}
