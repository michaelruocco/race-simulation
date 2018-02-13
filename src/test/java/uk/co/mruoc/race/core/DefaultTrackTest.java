package uk.co.mruoc.race.core;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class DefaultTrackTest {

    private final DefaultTrack track = new DefaultTrack();

    @Test
    public void shouldReturnDistancesBetweenCheckpoints() {
        assertThat(track.getDistanceBetweenCheckpoints(0, 1)).isEqualTo(BigDecimal.valueOf(800));
        assertThat(track.getDistanceBetweenCheckpoints(1, 2)).isEqualTo(BigDecimal.valueOf(1200));
        assertThat(track.getDistanceBetweenCheckpoints(2, 3)).isEqualTo(BigDecimal.valueOf(300));

        assertThat(track.getDistanceBetweenCheckpoints(3, 4)).isEqualTo(BigDecimal.valueOf(200));
        assertThat(track.getDistanceBetweenCheckpoints(4, 5)).isEqualTo(BigDecimal.valueOf(200));
        assertThat(track.getDistanceBetweenCheckpoints(5, 6)).isEqualTo(BigDecimal.valueOf(500));
        assertThat(track.getDistanceBetweenCheckpoints(3, 6)).isEqualTo(BigDecimal.valueOf(700));

        assertThat(track.getDistanceBetweenCheckpoints(6, 7)).isEqualTo(BigDecimal.valueOf(800));
        assertThat(track.getDistanceBetweenCheckpoints(7, 8)).isEqualTo(BigDecimal.valueOf(1200));
        assertThat(track.getDistanceBetweenCheckpoints(8, 9)).isEqualTo(BigDecimal.valueOf(400));
        assertThat(track.getDistanceBetweenCheckpoints(9, 0)).isEqualTo(BigDecimal.valueOf(600));
    }

    @Test
    public void shouldReturnNextCheckpointIdForNormalLap() {
        assertThat(track.getDistanceToNextCheckpoint(0)).isEqualTo(BigDecimal.valueOf(800));
        assertThat(track.getDistanceToNextCheckpoint(1)).isEqualTo(BigDecimal.valueOf(1200));
        assertThat(track.getDistanceToNextCheckpoint(2)).isEqualTo(BigDecimal.valueOf(300));
        assertThat(track.getDistanceToNextCheckpoint(3)).isEqualTo(BigDecimal.valueOf(700));
        assertThat(track.getDistanceToNextCheckpoint(4)).isEqualTo(BigDecimal.valueOf(200));
        assertThat(track.getDistanceToNextCheckpoint(5)).isEqualTo(BigDecimal.valueOf(500));
        assertThat(track.getDistanceToNextCheckpoint(6)).isEqualTo(BigDecimal.valueOf(800));
        assertThat(track.getDistanceToNextCheckpoint(7)).isEqualTo(BigDecimal.valueOf(1200));
        assertThat(track.getDistanceToNextCheckpoint(8)).isEqualTo(BigDecimal.valueOf(400));
        assertThat(track.getDistanceToNextCheckpoint(9)).isEqualTo(BigDecimal.valueOf(600));
    }

    @Test
    public void shouldThrowExceptionIfNextCheckpointIdNotFound() {
        Throwable thrown = catchThrowable(() -> track.getDistanceToNextCheckpoint(10));

        assertThat(thrown).isInstanceOf(NextCheckpointIdNotFoundException.class)
                .hasMessage("next checkpoint id not found for checkpoint id 10");
    }

    @Test
    public void shouldReturnPitCheckpointIds() {
        assertThat(track.isPit(0, 1)).isFalse();
        assertThat(track.isPit(1, 2)).isFalse();
        assertThat(track.isPit(2, 3)).isFalse();
        assertThat(track.isPit(3, 4)).isFalse();
        assertThat(track.isPit(4, 5)).isTrue();
        assertThat(track.isPit(5, 6)).isFalse();
        assertThat(track.isPit(6, 7)).isFalse();
        assertThat(track.isPit(7, 8)).isFalse();
        assertThat(track.isPit(8, 9)).isFalse();
        assertThat(track.isPit(9, 0)).isFalse();
        assertThat(track.isPit(3, 6)).isFalse();
    }

}
