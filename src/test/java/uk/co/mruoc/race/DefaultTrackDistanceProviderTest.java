package uk.co.mruoc.race;

import org.junit.Test;
import uk.co.mruoc.race.model.DefaultTrackDistanceProvider;
import uk.co.mruoc.race.model.DistanceProvider;
import uk.co.mruoc.race.model.NextCheckpointIdNotFoundException;

import java.math.BigDecimal;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

public class DefaultTrackDistanceProviderTest {

    private final DistanceProvider provider = new DefaultTrackDistanceProvider();

    @Test
    public void shouldReturnDistancesBetweenCheckpoints() {
        assertThat(provider.getDistanceBetweenCheckpoints(0, 1)).isEqualTo(BigDecimal.valueOf(800));
        assertThat(provider.getDistanceBetweenCheckpoints(1, 2)).isEqualTo(BigDecimal.valueOf(1200));
        assertThat(provider.getDistanceBetweenCheckpoints(2, 3)).isEqualTo(BigDecimal.valueOf(300));

        assertThat(provider.getDistanceBetweenCheckpoints(3, 4)).isEqualTo(BigDecimal.valueOf(200));
        assertThat(provider.getDistanceBetweenCheckpoints(4, 5)).isEqualTo(BigDecimal.valueOf(200));
        assertThat(provider.getDistanceBetweenCheckpoints(5, 6)).isEqualTo(BigDecimal.valueOf(500));
        assertThat(provider.getDistanceBetweenCheckpoints(3, 6)).isEqualTo(BigDecimal.valueOf(700));

        assertThat(provider.getDistanceBetweenCheckpoints(6, 7)).isEqualTo(BigDecimal.valueOf(800));
        assertThat(provider.getDistanceBetweenCheckpoints(7, 8)).isEqualTo(BigDecimal.valueOf(1200));
        assertThat(provider.getDistanceBetweenCheckpoints(8, 9)).isEqualTo(BigDecimal.valueOf(400));
        assertThat(provider.getDistanceBetweenCheckpoints(9, 0)).isEqualTo(BigDecimal.valueOf(600));
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
