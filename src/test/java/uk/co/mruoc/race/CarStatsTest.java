package uk.co.mruoc.race;

import org.junit.Test;
import uk.co.mruoc.race.model.CarData;
import uk.co.mruoc.race.model.CarStats;
import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CarStatsTest {

    private static final int POSITION = 1;

    private final ElapsedTime timeDifference = new ElapsedTime();
    private final CarData carData = mock(CarData.class);

    private final CarStats carStats = new CarStats(POSITION, timeDifference, carData);

    @Test
    public void shouldReturnPosition() {
        assertThat(carStats.getPosition()).isEqualTo(POSITION);
    }

    @Test
    public void shouldReturnCarId() {
        int carId = 7;
        given(carData.getCarId()).willReturn(carId);

        assertThat(carStats.getCarId()).isEqualTo(carId);
    }

    @Test
    public void shouldReturnLapNumber() {
        int lapNumber = 2;
        given(carData.getLapNumber()).willReturn(lapNumber);

        assertThat(carStats.getLapNumber()).isEqualTo(lapNumber);
    }

    @Test
    public void shouldReturnDistance() {
        BigDecimal distance = BigDecimal.valueOf(300);
        given(carData.getDistance()).willReturn(distance);

        assertThat(carStats.getDistance()).isEqualTo(distance);
    }

    @Test
    public void shouldReturnTimeDifference() {
        assertThat(carStats.getTimeDifference()).isEqualTo(timeDifference);
    }

    @Test
    public void shouldReturnSpeed() {
        BigDecimal speed = BigDecimal.valueOf(150);
        given(carData.getSpeed()).willReturn(speed);

        assertThat(carStats.getSpeed()).isEqualTo(speed);
    }

}
