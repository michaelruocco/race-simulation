package uk.co.mruoc.race.core;

import org.junit.Test;
import uk.co.mruoc.race.core.LapStats.LapStatsBuilder;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class LapStatsTest {

    private final LapStatsBuilder builder = new LapStatsBuilder();

    @Test
    public void shouldReturnTotalDistance() {
        BigDecimal totalDistance = BigDecimal.valueOf(100);

        LapStats stats = builder.setTotalDistance(totalDistance).build();

        assertThat(stats.getTotalDistance()).isEqualTo(totalDistance);
    }

    @Test
    public void shouldReturnDistance() {
        BigDecimal distance = BigDecimal.valueOf(500);

        LapStats stats = builder.setDistance(distance).build();

        assertThat(stats.getDistance()).isEqualTo(distance);
    }

    @Test
    public void shouldReturnSpeed() {
        BigDecimal speed = BigDecimal.valueOf(0.5);

        LapStats stats = builder.setSpeed(speed).build();

        assertThat(stats.getSpeed()).isEqualTo(speed);
    }

    @Test
    public void shouldReturnProgress() {
        BigDecimal progress = BigDecimal.valueOf(0.8);

        LapStats stats = builder.setProgress(progress).build();

        assertThat(stats.getProgress()).isEqualTo(progress);
    }

    @Test
    public void shouldReturnAverageLapSpeed() {
        BigDecimal averageLapSpeed = BigDecimal.valueOf(0.9);

        LapStats stats = builder.setAverageLapSpeed(averageLapSpeed).build();

        assertThat(stats.getAverageLapSpeed()).isEqualTo(averageLapSpeed);
    }

}
