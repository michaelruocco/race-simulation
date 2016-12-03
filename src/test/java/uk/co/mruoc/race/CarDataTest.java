package uk.co.mruoc.race;

import org.junit.Before;
import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

public class CarDataTest {

    private static final int CAR_ID = 1;

    private final DistanceProvider distanceProvider = new DefaultDistanceProvider();
    private final TestFileLineBuilder fileLineBuilder = new TestFileLineBuilder();

    private final CarData carData = new CarData(distanceProvider, CAR_ID);

    @Before
    public void setUp() {
        distanceProvider.add("0-1", 800d);
        distanceProvider.add("1-2", 1200d);
    }

    @Test
    public void shouldReturnCarId() {
        assertThat(carData.getCarId()).isEqualTo(CAR_ID);
    }

    @Test
    public void shouldInitiallyHaveNoLines() {
        assertThat(carData.size()).isEqualTo(0);
    }

    @Test
    public void sizeShouldIncrementWhenLinesAdded() {
        carData.add(fileLineBuilder.withCarId(CAR_ID).build());

        assertThat(carData.size()).isEqualTo(1);
    }

    @Test
    public void shouldThrowExceptionIfLineWithWrongCarIdAdded() {
        when(carData).add(fileLineBuilder.withCarId(2).build());

        then(caughtException())
                .isInstanceOf(WrongCarDataException.class)
                .hasMessage("added file line for car id 2 but should be for car id 1");
    }

    @Test
    public void shouldReturnTimeFromLastLineAdded() {
        ElapsedTime time = new ElapsedTime("01:00:00.000");
        carData.add(fileLineBuilder.withCarId(CAR_ID).build());
        carData.add(fileLineBuilder.withCarId(CAR_ID).build());
        carData.add(fileLineBuilder.withCarId(CAR_ID).withTime(time).build());

        assertThat(carData.getEndTime()).isEqualTo(time);
    }

    @Test
    public void shouldReturnDistanceTravelledAtGivenTime() {
        carData.add(fileLineBuilder.withCarId(CAR_ID).withCheckpointId(0).withTime(new ElapsedTime()).build());
        carData.add(fileLineBuilder.withCarId(CAR_ID).withCheckpointId(1).withTime(new ElapsedTime("00:00:01.000")).build());
        carData.add(fileLineBuilder.withCarId(CAR_ID).withCheckpointId(2).withTime(new ElapsedTime("00:00:02.000")).build());
        carData.setTime(new ElapsedTime("00:00:02.000"));

        double distance = carData.getDistance();

        assertThat(distance).isEqualTo(2000);
    }

    @Test
    public void shouldReturnLapNumberAtGivenTimeWhenCarHasRetired() {
        carData.add(fileLineBuilder.withCarId(CAR_ID).withCheckpointId(0).withTime(new ElapsedTime()).build());
        carData.add(fileLineBuilder.withCarId(CAR_ID).withCheckpointId(1).withTime(new ElapsedTime("00:00:01.000")).build());
        carData.add(fileLineBuilder.withCarId(CAR_ID).withCheckpointId(-1).withTime(new ElapsedTime("00:00:02.000")).build());
        carData.setTime(new ElapsedTime("00:00:02.000"));

        double distance = carData.getDistance();

        assertThat(distance).isEqualTo(2000);
    }

    @Test
    public void shouldReturnLapNumberAtGivenTime() {
        carData.add(fileLineBuilder.withCarId(CAR_ID).withCheckpointId(0).withTime(new ElapsedTime()).build());
        carData.add(fileLineBuilder.withCarId(CAR_ID).withCheckpointId(1).withTime(new ElapsedTime("00:00:01.000")).build());
        carData.add(fileLineBuilder.withCarId(CAR_ID).withCheckpointId(2).withTime(new ElapsedTime("00:00:02.000")).build());
        carData.setTime(new ElapsedTime("00:00:02.000"));

        int lapNumber = carData.getLapNumber();

        assertThat(lapNumber).isEqualTo(1);
    }

}
