package uk.co.mruoc.race.model;

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
        assertThat(provider.getDistanceToNextCheckpoint(0)).isEqualTo(BigDecimal.valueOf(800));
        assertThat(provider.getDistanceToNextCheckpoint(1)).isEqualTo(BigDecimal.valueOf(1200));
        assertThat(provider.getDistanceToNextCheckpoint(2)).isEqualTo(BigDecimal.valueOf(300));
        assertThat(provider.getDistanceToNextCheckpoint(3)).isEqualTo(BigDecimal.valueOf(700));
        assertThat(provider.getDistanceToNextCheckpoint(4)).isEqualTo(BigDecimal.valueOf(200));
        assertThat(provider.getDistanceToNextCheckpoint(5)).isEqualTo(BigDecimal.valueOf(500));
        assertThat(provider.getDistanceToNextCheckpoint(6)).isEqualTo(BigDecimal.valueOf(800));
        assertThat(provider.getDistanceToNextCheckpoint(7)).isEqualTo(BigDecimal.valueOf(1200));
        assertThat(provider.getDistanceToNextCheckpoint(8)).isEqualTo(BigDecimal.valueOf(400));
        assertThat(provider.getDistanceToNextCheckpoint(9)).isEqualTo(BigDecimal.valueOf(600));
    }

    @Test
    public void shouldThrowExceptionIfNextCheckpointIdNotFound() {
        when(provider).getDistanceToNextCheckpoint(10);

        then(caughtException())
                .isInstanceOf(NextCheckpointIdNotFoundException.class)
                .hasMessage("next checkpoint id not found for checkpoint id 10");
    }

}
