package uk.co.mruoc.race.core;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.mruoc.race.core.SplitStats.*;

public class SplitStatsTest {

    private final SplitStatsBuilder builder = new SplitStatsBuilder();

    @Test
    public void shouldReturnId() {
        String id = "0-1";

        SplitStats stats = builder.setId(id).build();

        assertThat(stats.getId()).isEqualTo(id);
    }

    @Test
    public void shouldReturnTotalDistance() {
        BigDecimal totalDistance = BigDecimal.valueOf(100);

        SplitStats stats = builder.setTotalDistance(totalDistance).build();

        assertThat(stats.getTotalDistance()).isEqualTo(totalDistance);
    }

    @Test
    public void shouldReturnDistance() {
        BigDecimal distance = BigDecimal.valueOf(500);

        SplitStats stats = builder.setDistance(distance).build();

        assertThat(stats.getDistance()).isEqualTo(distance);
    }

    @Test
    public void shouldReturnSpeed() {
        BigDecimal speed = BigDecimal.valueOf(0.5);

        SplitStats stats = builder.setSpeed(speed).build();

        assertThat(stats.getSpeed()).isEqualTo(speed);
    }

    @Test
    public void shouldReturnProgress() {
        BigDecimal progress = BigDecimal.valueOf(0.8);

        SplitStats stats = builder.setProgress(progress).build();

        assertThat(stats.getProgress()).isEqualTo(progress);
    }

}
