package uk.co.mruoc.race.model;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;

import static org.assertj.core.api.Assertions.assertThat;

public class FileLineTest {

    private final TestFileLineBuilder builder = new TestFileLineBuilder();

    @Test
    public void shouldReturnRetiredIfCheckpointIdIsRetired() {
        FileLine line = builder.setCheckpointId(-1).build();

        assertThat(line.isRetired()).isTrue();
    }

    @Test
    public void shouldNotReturnRetiredIfCheckpointIdIsNotRetired() {
        FileLine line = builder.setCheckpointId(0).build();

        assertThat(line.isRetired()).isFalse();
    }

    @Test
    public void shouldReturnCarId() {
        int carId = 3;

        FileLine line = builder.setCarId(carId).build();

        assertThat(line.getCarId()).isEqualTo(carId);
    }

    @Test
    public void shouldReturnCheckpointId() {
        int checkpointId = 1;

        FileLine line = builder.setCheckpointId(checkpointId).build();

        assertThat(line.getCheckpointId()).isEqualTo(checkpointId);
    }

    @Test
    public void shouldReturnQueried() {
        boolean queried = true;

        FileLine line = builder.setQueried(queried).build();

        assertThat(line.isQueried()).isEqualTo(queried);
    }

    @Test
    public void shouldReturnTime() {
        ElapsedTime time = new ElapsedTime();

        FileLine line = builder.setTime(time).build();

        assertThat(line.getTime()).isEqualTo(time);
    }


}
