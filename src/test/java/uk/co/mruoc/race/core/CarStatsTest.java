package uk.co.mruoc.race.core;

import org.junit.Test;
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

    @Test
    public void shouldReturnAverageLapSpeed() {
        BigDecimal averageLapSpeed = BigDecimal.valueOf(250);
        given(carData.getAverageLapSpeed()).willReturn(averageLapSpeed);

        assertThat(carStats.getAverageLapSpeed()).isEqualTo(averageLapSpeed);
    }

    @Test
    public void shouldReturnMaximumAverageLapSpeed() {
        BigDecimal maximumAverageLapSpeed = BigDecimal.valueOf(250);
        given(carData.getMaximumAverageLapSpeed()).willReturn(maximumAverageLapSpeed);

        assertThat(carStats.getMaximumAverageLapSpeed()).isEqualTo(maximumAverageLapSpeed);
    }

    @Test
    public void shouldReturnHasPitted() {
        boolean pitted = true;
        given(carData.hasPitted()).willReturn(pitted);

        assertThat(carStats.hasPitted()).isEqualTo(pitted);
    }

    @Test
    public void shouldReturnPitTime() {
        ElapsedTime pitTime = new ElapsedTime();
        given(carData.getPitTime()).willReturn(pitTime);

        assertThat(carStats.getPitTime()).isEqualTo(pitTime);
    }

    @Test
    public void shouldReturnPitLapNumber() {
        int pitLapNumber = 4;
        given(carData.getPitLapNumber()).willReturn(pitLapNumber);

        assertThat(carStats.getPitLapNumber()).isEqualTo(pitLapNumber);
    }

    @Test
    public void shouldReturnRetired() {
        boolean retired = true;
        given(carData.hasRetired()).willReturn(retired);

        assertThat(carStats.hasRetired()).isEqualTo(retired);
    }

    @Test
    public void shouldReturnRetiredTime() {
        ElapsedTime retiredTime = new ElapsedTime();
        given(carData.getRetiredTime()).willReturn(retiredTime);

        assertThat(carStats.getRetiredTime()).isEqualTo(retiredTime);
    }

}
