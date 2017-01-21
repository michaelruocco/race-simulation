package uk.co.mruoc.race.model;

import org.junit.Before;
import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CarDataTest {

    private static final int CAR_ID = 2;

    private final Lap lap1 = mock(Lap.class);
    private final Lap lap2 = mock(Lap.class);
    private final List<Lap> laps = Arrays.asList(lap1, lap2);

    private final CarData carData = new CarData(CAR_ID, laps);

    @Before
    public void setUp() {
        given(lap1.getEndTime()).willReturn(new ElapsedTime());
        given(lap2.getEndTime()).willReturn(new ElapsedTime());
    }

    @Test
    public void shouldReturnCarId() {
        assertThat(carData.getCarId()).isEqualTo(CAR_ID);
    }

    @Test
    public void distanceShouldDefaultToZero() {
        assertThat(carData.getDistance()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void speedShouldDefaultToZero() {
        assertThat(carData.getSpeed()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void averageLapSpeedShouldDefaultToZero() {
        assertThat(carData.getAverageLapSpeed()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void lapNumberShouldDefaultToZero() {
        assertThat(carData.getLapNumber()).isEqualTo(0);
    }

    @Test
    public void shouldReturnEndTimeOfLastLap() {
        ElapsedTime endTime = new ElapsedTime("00:00:35.123");
        given(lap2.getEndTime()).willReturn(endTime);

        assertThat(carData.getEndTime()).isEqualTo(endTime);
    }

    @Test
    public void shouldReturnLapNumberAtGivenTime() {
        ElapsedTime time = new ElapsedTime("00:00:35.123");
        int lapNumber = 3;
        given(lap1.contains(time)).willReturn(true);
        given(lap1.getLapNumber()).willReturn(lapNumber);

        carData.setTime(time);

        assertThat(carData.getLapNumber()).isEqualTo(lapNumber);
    }

    @Test
    public void shouldReturnLastLapNumberIfGivenTimeAfterEndOfAllLaps() {
        ElapsedTime time = new ElapsedTime("00:00:35.123");
        int lapNumber = 4;
        given(lap2.getLapNumber()).willReturn(lapNumber);

        carData.setTime(time);

        assertThat(carData.getLapNumber()).isEqualTo(lapNumber);
    }

    @Test
    public void shouldReturnDistanceAtGivenTime() {
        BigDecimal distance = BigDecimal.valueOf(150);
        LapStats lapStats = mock(LapStats.class);
        given(lapStats.getTotalDistance()).willReturn(distance);

        ElapsedTime time = new ElapsedTime("00:30:30.000");
        given(lap2.getStatsAt(time)).willReturn(lapStats);

        carData.setTime(time);

        assertThat(carData.getDistance()).isEqualTo(distance);
    }

    @Test
    public void shouldReturnSpeedAtGivenTime() {
        BigDecimal speed = BigDecimal.valueOf(0.5);
        LapStats lapStats = mock(LapStats.class);
        given(lapStats.getSpeed()).willReturn(speed);

        ElapsedTime time = new ElapsedTime("00:30:30.000");
        given(lap2.getStatsAt(time)).willReturn(lapStats);

        carData.setTime(time);

        assertThat(carData.getSpeed()).isEqualTo(speed);
    }

    @Test
    public void shouldReturnAverageLapSpeedAtGivenTime() {
        BigDecimal averageLapSpeed = BigDecimal.valueOf(0.5);
        LapStats lapStats = mock(LapStats.class);
        given(lapStats.getAverageLapSpeed()).willReturn(averageLapSpeed);

        ElapsedTime time = new ElapsedTime("00:30:30.000");
        given(lap2.getStatsAt(time)).willReturn(lapStats);

        carData.setTime(time);

        assertThat(carData.getAverageLapSpeed()).isEqualTo(averageLapSpeed);
    }

    @Test
    public void shouldReturnMaxmimumAverageLapSpeedAtGivenTime() {
        BigDecimal maximumAverageLapSpeed = BigDecimal.valueOf(0.6);
        ElapsedTime time = new ElapsedTime("00:30:30.000");
        given(lap1.getWholeAverageLapSpeed()).willReturn(maximumAverageLapSpeed);
        given(lap2.getWholeAverageLapSpeed()).willReturn(BigDecimal.valueOf(0.5));

        carData.setTime(time);

        assertThat(carData.getMaximumAverageLapSpeed()).isEqualTo(maximumAverageLapSpeed);
    }

    @Test
    public void shouldReturnZeroMaxmimumAverageLapSpeedIfNoLapsCompleted() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");
        given(lap1.getWholeAverageLapSpeed()).willReturn(BigDecimal.valueOf(0.5));
        given(lap2.getWholeAverageLapSpeed()).willReturn(BigDecimal.valueOf(0.6));

        carData.setTime(time);

        assertThat(carData.getMaximumAverageLapSpeed()).isEqualTo(BigDecimal.ZERO);
    }

}
