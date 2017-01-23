package uk.co.mruoc.race.model;

import org.junit.Test;
import uk.co.mruoc.race.model.PitStats.PitStatsBuilder;
import uk.co.mruoc.race.model.RetiredStats.RetiredStatsBuilder;
import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class RetiredStatsTest {

    private final RetiredStatsBuilder builder = new RetiredStatsBuilder();

    @Test
    public void retiredShouldDefaultToFalse() {
        RetiredStats stats = builder.build();

        assertThat(stats.hasRetired()).isFalse();
    }

    @Test
    public void timeShouldDefaultToZeroTime() {
        RetiredStats stats = builder.build();

        assertThat(stats.getTime()).isEqualTo(new ElapsedTime());
    }

    @Test
    public void shouldReturnRetired() {
        boolean retired = true;

        RetiredStats stats = builder.setRetired(retired).build();

        assertThat(stats.hasRetired()).isEqualTo(retired);
    }

    @Test
    public void shouldReturnTime() {
        ElapsedTime time = new ElapsedTime();

        RetiredStats stats = builder.setTime(time).build();

        assertThat(stats.getTime()).isEqualTo(time);
    }

}
