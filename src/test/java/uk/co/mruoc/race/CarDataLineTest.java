package uk.co.mruoc.race;

import org.junit.Test;
import uk.co.mruoc.race.CarDataLine.CarDataLineBuilder;
import uk.co.mruoc.time.ElapsedTime;

import static org.assertj.core.api.Assertions.assertThat;

public class CarDataLineTest {

    private final CarDataLineBuilder builder = new CarDataLineBuilder();

    @Test
    public void shouldReturnCheckpointId() {
        int checkpointId = 1;
        CarDataLine line = builder.setCheckpointId(checkpointId).build();

        assertThat(line.getCheckpointId()).isEqualTo(checkpointId);
    }

    @Test
    public void shouldReturnTime() {
        ElapsedTime time = new ElapsedTime();
        CarDataLine line = builder.setTime(time).build();

        assertThat(line.getTime()).isEqualTo(time);
    }

    @Test
    public void shouldReturnLapNumber() {
        int lapNumber = 5;
        CarDataLine line = builder.setLapNumber(lapNumber).build();

        assertThat(line.getLapNumber()).isEqualTo(lapNumber);
    }

    @Test
    public void shouldReturnDistance() {
        double distance = 1200;
        CarDataLine line = builder.setDistance(distance).build();

        assertThat(line.getDistance()).isEqualTo(distance);
    }

}
