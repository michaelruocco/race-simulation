package uk.co.mruoc.race.core;

import org.junit.Test;

import java.math.BigDecimal;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

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
        when(provider).getDistanceToNextCheckpoint(0);

        then(caughtException())
                .isInstanceOf(NextCheckpointIdNotFoundException.class)
                .hasMessage("next checkpoint id not found for checkpoint id 0");
    }

    @Test
    public void shouldReturnZeroIfSplitNotFound() {
        assertThat(provider.getDistanceBetweenCheckpoints(0, 1)).isEqualTo(BigDecimal.ZERO);
    }

}
