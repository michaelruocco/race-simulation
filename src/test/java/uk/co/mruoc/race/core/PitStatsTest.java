package uk.co.mruoc.race.core;

import org.junit.Test;
import uk.co.mruoc.race.core.PitStats.PitStatsBuilder;
import uk.co.mruoc.time.ElapsedTime;

import static org.assertj.core.api.Assertions.assertThat;

public class PitStatsTest {

    private final PitStatsBuilder builder = new PitStatsBuilder();

    @Test
    public void pittedShouldDefaultToFalse() {
        PitStats stats = builder.build();

        assertThat(stats.hasPitted()).isFalse();
    }

    @Test
    public void timeShouldDefaultToZeroTime() {
        PitStats stats = builder.build();

        assertThat(stats.getTime()).isEqualTo(new ElapsedTime());
    }

    @Test
    public void lapNumberShouldDefaultToZero() {
        PitStats stats = builder.build();

        assertThat(stats.getLapNumber()).isEqualTo(0);
    }

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
