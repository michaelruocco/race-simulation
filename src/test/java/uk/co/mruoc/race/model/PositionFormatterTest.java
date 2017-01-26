package uk.co.mruoc.race.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class PositionFormatterTest {

    private final CarStats stats = mock(CarStats.class);

    private final CarStatFormatter formatter = new PositionFormatter();

    @Test
    public void shouldFormatPosition() {
        int position = 5;
        given(stats.getPosition()).willReturn(position);

        assertThat(formatter.format(stats)).isEqualTo(Integer.toString(position));
    }

}
