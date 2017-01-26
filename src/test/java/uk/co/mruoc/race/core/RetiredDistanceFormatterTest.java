package uk.co.mruoc.race.core;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static uk.co.mruoc.race.core.CarStatFormatter.NOT_APPLICABLE;

public class RetiredDistanceFormatterTest {

    private final CarStats stats = mock(CarStats.class);

    private final CarStatFormatter formatter = new RetiredDistanceFormatter();

    @Test
    public void shouldReturnNotApplicableIfNotRetired() {
        assertThat(formatter.format(stats)).isEqualTo(NOT_APPLICABLE);
    }

    @Test
    public void shouldFormatRetiredDistanceIfRetired() {
        BigDecimal distance = BigDecimal.valueOf(123.123);
        given(stats.hasRetired()).willReturn(true);
        given(stats.getDistance()).willReturn(distance);

        assertThat(formatter.format(stats)).isEqualTo("123.12");
    }

}
