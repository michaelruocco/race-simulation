package uk.co.mruoc.race.model;

import org.junit.Test;
import uk.co.mruoc.race.model.PitStats.PitStatsBuilder;
import uk.co.mruoc.time.ElapsedTime;

import static org.assertj.core.api.Assertions.assertThat;

public class PitStatsTest {

    private final PitStatsBuilder builder = new PitStatsBuilder();

    @Test
    public void shouldReturnPitted() {
        boolean pitted = true;

        PitStats stats = builder.setPitted(pitted).build();

        assertThat(stats.hasPitted()).isEqualTo(pitted);
    }

    @Test
    public void shouldReturnTime() {
        ElapsedTime time = new ElapsedTime();

        PitStats stats = builder.setTime(time).build();

        assertThat(stats.getTime()).isEqualTo(time);
    }

    @Test
    public void shouldReturnLapNumber() {
        int lapNumber = 3;

        PitStats stats = builder.setLapNumber(lapNumber).build();

        assertThat(stats.getLapNumber()).isEqualTo(lapNumber);
    }

}
