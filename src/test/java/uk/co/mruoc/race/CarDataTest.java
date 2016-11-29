package uk.co.mruoc.race;

import org.junit.Test;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

public class CarDataTest {

    private static final int CAR_ID = 1;

    private final DistanceProvider distanceProvider = new DefaultDistanceProvider();
    private final CarData carData = new CarData(distanceProvider, CAR_ID);

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
        carData.add(new TestFileLineBuilder().withCarId(CAR_ID).build());

        assertThat(carData.size()).isEqualTo(1);
    }

    @Test
    public void shouldThrowExceptionIfLineWithWrongCarIdAdded() {
        when(carData).add(new TestFileLineBuilder().withCarId(2).build());

        then(caughtException())
                .isInstanceOf(WrongCarDataException.class)
                .hasMessage("added file line for car id 2 but should be for car id 1");
    }


}
