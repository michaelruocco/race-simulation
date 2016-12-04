package uk.co.mruoc.race;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CarStatsTest {

    private static final int POSITION = 1;

    private final CarData carData = mock(CarData.class);

    private final CarStats carStats = new CarStats(POSITION, carData);

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
        double distance = 300d;
        given(carData.getDistance()).willReturn(distance);

        assertThat(carStats.getDistance()).isEqualTo(distance);
    }

}
