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
        assertThat(provider.getDistanceBetweenCheckpoints(0, 1)).isEqualTo(800);
        assertThat(provider.getDistanceBetweenCheckpoints(1, 2)).isEqualTo(1200);
        assertThat(provider.getDistanceBetweenCheckpoints(2, 3)).isEqualTo(300);

        assertThat(provider.getDistanceBetweenCheckpoints(3, 4)).isEqualTo(200);
        assertThat(provider.getDistanceBetweenCheckpoints(4, 5)).isEqualTo(200);
        assertThat(provider.getDistanceBetweenCheckpoints(5, 6)).isEqualTo(500);
        assertThat(provider.getDistanceBetweenCheckpoints(3, 6)).isEqualTo(700);

        assertThat(provider.getDistanceBetweenCheckpoints(6, 7)).isEqualTo(800);
        assertThat(provider.getDistanceBetweenCheckpoints(7, 8)).isEqualTo(1200);
        assertThat(provider.getDistanceBetweenCheckpoints(8, 9)).isEqualTo(400);
        assertThat(provider.getDistanceBetweenCheckpoints(9, 0)).isEqualTo(600);
    }

    @Test
    public void shouldReturnNextCheckpointIdForNormalLap() {
        assertThat(provider.getNextCheckpointId(0)).isEqualTo(1);
        assertThat(provider.getNextCheckpointId(1)).isEqualTo(2);
        assertThat(provider.getNextCheckpointId(2)).isEqualTo(3);
        assertThat(provider.getNextCheckpointId(3)).isEqualTo(6);
        assertThat(provider.getNextCheckpointId(4)).isEqualTo(5);
        assertThat(provider.getNextCheckpointId(5)).isEqualTo(6);
        assertThat(provider.getNextCheckpointId(6)).isEqualTo(7);
        assertThat(provider.getNextCheckpointId(7)).isEqualTo(8);
        assertThat(provider.getNextCheckpointId(8)).isEqualTo(9);
        assertThat(provider.getNextCheckpointId(9)).isEqualTo(0);
    }

    @Test
    public void shouldThrowExceptionIfNextCheckpointIdNotFound() {
        when(provider).getNextCheckpointId(10);

        then(caughtException())
                .isInstanceOf(NextCheckpointIdNotFoundException.class)
                .hasMessage("next checkpoint id not found for checkpoint id 10");
    }

}
