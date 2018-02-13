package uk.co.mruoc.race.core;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class DefaultDistanceProviderTest {

    private final DistanceProvider provider = new DefaultDistanceProvider();

    @Test
    public void shouldReturnDistancesBetweenCheckpoints() {
        BigDecimal distance = BigDecimal.valueOf(500);
        provider.add("0-1", distance);

        assertThat(provider.getDistanceBetweenCheckpoints(0, 1)).isEqualTo(distance);
    }

    @Test
    public void shouldReturnDistanceToNextCheckpointForNormalLap() {
        BigDecimal distance = BigDecimal.valueOf(500);
        provider.add("0-1", distance);

        assertThat(provider.getDistanceToNextCheckpoint(0)).isEqualTo(distance);
    }

    @Test
    public void shouldThrowExceptionIfNextCheckpointIdNotFound() {
        Throwable thrown = catchThrowable(() -> provider.getDistanceToNextCheckpoint(0));

        assertThat(thrown).isInstanceOf(NextCheckpointIdNotFoundException.class)
                .hasMessage("next checkpoint id not found for checkpoint id 0");
    }

    @Test
    public void shouldReturnZeroIfSplitNotFound() {
        assertThat(provider.getDistanceBetweenCheckpoints(0, 1)).isEqualTo(BigDecimal.ZERO);
    }

}
