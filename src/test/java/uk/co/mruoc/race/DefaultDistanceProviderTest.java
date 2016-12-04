package uk.co.mruoc.race;

import org.junit.Test;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

public class DefaultDistanceProviderTest {

    private final DistanceProvider provider = new DefaultDistanceProvider();

    @Test
    public void shouldReturnDistancesBetweenCheckpoints() {
        double distance = 500;
        provider.add("0-1", distance);

        assertThat(provider.getDistanceBetweenCheckpoints(0, 1)).isEqualTo(distance);
    }

    @Test
    public void shouldReturnNextCheckpointIdForNormalLap() {
        provider.add("0-1", 0);

        assertThat(provider.getNextCheckpointId(0)).isEqualTo(1);
    }

    @Test
    public void shouldThrowExceptionIfNextCheckpointIdNotFound() {
        when(provider).getNextCheckpointId(0);

        then(caughtException())
                .isInstanceOf(NextCheckpointIdNotFoundException.class)
                .hasMessage("next checkpoint id not found for checkpoint id 0");
    }

}
