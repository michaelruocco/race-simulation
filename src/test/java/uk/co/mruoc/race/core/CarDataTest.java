package uk.co.mruoc.race.core;

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
    public void splitIdShouldDefaultToEmptyString() {
        assertThat(carData.getSplitId()).isEmpty();
    }

    @Test
    public void splitProgressShouldDefaultToZero() {
        assertThat(carData.getSplitProgress()).isEqualTo(BigDecimal.ZERO);
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
    public void shouldReturnSplitIdAtGivenTime() {
        String splitId = "0-1";
        LapStats lapStats = mock(LapStats.class);
        given(lapStats.getSplitId()).willReturn(splitId);

        ElapsedTime time = new ElapsedTime("00:30:30.000");
        given(lap2.getStatsAt(time)).willReturn(lapStats);

        carData.setTime(time);

        assertThat(carData.getSplitId()).isEqualTo(splitId);
    }

    @Test
    public void shouldReturnSplitProgressAtGivenTime() {
        BigDecimal splitProgress = BigDecimal.valueOf(0.5);
        LapStats lapStats = mock(LapStats.class);
        given(lapStats.getSplitProgress()).willReturn(splitProgress);

        ElapsedTime time = new ElapsedTime("00:30:30.000");
        given(lap2.getStatsAt(time)).willReturn(lapStats);

        carData.setTime(time);

        assertThat(carData.getSplitProgress()).isEqualTo(splitProgress);
    }

    @Test
    public void shouldReturnMaxmimumAverageLapSpeedAtGivenTime() {
        BigDecimal maximumAverageLapSpeed = BigDecimal.valueOf(0.6);
        ElapsedTime time = new ElapsedTime("00:30:30.000");
        given(lap1.getWholeAverageLapSpeed()).willReturn(maximumAverageLapSpeed);
        given(lap1.isCompleteAt(time)).willReturn(true);
        given(lap2.getWholeAverageLapSpeed()).willReturn(BigDecimal.valueOf(0.5));
        given(lap2.isCompleteAt(time)).willReturn(true);

        carData.setTime(time);

        assertThat(carData.getMaximumAverageLapSpeed()).isEqualTo(maximumAverageLapSpeed);
    }

    @Test
    public void shouldReturnZeroMaximumAverageLapSpeedIfNoLapsCompleted() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");
        given(lap1.getWholeAverageLapSpeed()).willReturn(BigDecimal.valueOf(0.5));
        given(lap2.getWholeAverageLapSpeed()).willReturn(BigDecimal.valueOf(0.6));

        carData.setTime(time);

        assertThat(carData.getMaximumAverageLapSpeed()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void shouldReturnZeroMaximumAverageLapSpeedIfNoLapsCompletedBecauseRetired() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");
        given(lap1.getWholeAverageLapSpeed()).willReturn(BigDecimal.valueOf(0.5));
        given(lap1.isCompleteAt(time)).willReturn(true);
        given(lap1.isRetired()).willReturn(true);

        carData.setTime(time);

        assertThat(carData.getMaximumAverageLapSpeed()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void shouldReturnPittedFalseIfNoPitStopTaken() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");

        carData.setTime(time);

        assertThat(carData.hasPitted()).isFalse();
    }

    @Test
    public void shouldReturnZeroPitTimeIfNoPitStopTaken() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");

        carData.setTime(time);

        assertThat(carData.getPitTime()).isEqualTo(new ElapsedTime());
    }

    @Test
    public void shouldReturnZeroPitLapNumberIfNoPitStopTaken() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");

        carData.setTime(time);

        assertThat(carData.getPitLapNumber()).isEqualTo(0);
    }

    @Test
    public void shouldReturnHasPittedFalseIfBeforePitOnCurrentLap() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");

        given(lap1.contains(time)).willReturn(true);
        given(lap1.isPittedAt(time)).willReturn(false);

        carData.setTime(time);

        assertThat(carData.hasPitted()).isFalse();
    }

    @Test
    public void shouldReturnZeroPitTimeIfBeforePitOnCurrentLap() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");

        given(lap1.contains(time)).willReturn(true);
        given(lap1.isPittedAt(time)).willReturn(false);

        carData.setTime(time);

        assertThat(carData.getPitTime()).isEqualTo(new ElapsedTime());
    }

    @Test
    public void shouldReturnZeroPitLapNumberIfBeforePitOnCurrentLap() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");

        given(lap1.contains(time)).willReturn(true);
        given(lap1.isPittedAt(time)).willReturn(false);

        carData.setTime(time);

        assertThat(carData.getPitLapNumber()).isEqualTo(0);
    }

    @Test
    public void shouldReturnHasPittedTrueIfAfterPitOnCurrentLap() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");
        ElapsedTime pitTime = new ElapsedTime("00:00:10.000");
        int pitLapNumber = 1;

        given(lap1.contains(time)).willReturn(true);
        given(lap1.isPit()).willReturn(true);
        given(lap1.isPittedAt(time)).willReturn(true);
        given(lap1.getLapNumber()).willReturn(pitLapNumber);
        given(lap1.getPitTime()).willReturn(pitTime);

        carData.setTime(time);

        assertThat(carData.hasPitted()).isTrue();
    }

    @Test
    public void shouldReturnCurrentLapPitTimeIfAfterPitOnCurrentLap() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");
        ElapsedTime pitTime = new ElapsedTime("00:00:10.000");
        int pitLapNumber = 1;

        given(lap1.contains(time)).willReturn(true);
        given(lap1.isPittedAt(time)).willReturn(true);
        given(lap1.getLapNumber()).willReturn(pitLapNumber);
        given(lap1.getPitTime()).willReturn(pitTime);

        carData.setTime(time);

        assertThat(carData.getPitTime()).isEqualTo(pitTime);
    }

    @Test
    public void shouldReturnCurrentLapPitLapNumberIfAfterPitOnCurrentLap() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");
        ElapsedTime pitTime = new ElapsedTime("00:00:10.000");
        int pitLapNumber = 1;

        given(lap1.contains(time)).willReturn(true);
        given(lap1.isPittedAt(time)).willReturn(true);
        given(lap1.getLapNumber()).willReturn(pitLapNumber);
        given(lap1.getPitTime()).willReturn(pitTime);

        carData.setTime(time);

        assertThat(carData.getPitLapNumber()).isEqualTo(pitLapNumber);
    }

    @Test
    public void shouldReturnHasPittedTrueIfAfterPitLap() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");
        ElapsedTime pitTime = new ElapsedTime("00:00:15.000");
        int pitLapNumber = 1;

        given(lap1.isCompleteAt(time)).willReturn(true);
        given(lap1.isPit()).willReturn(true);
        given(lap1.getLapNumber()).willReturn(pitLapNumber);
        given(lap1.getPitTime()).willReturn(pitTime);

        carData.setTime(time);

        assertThat(carData.hasPitted()).isTrue();
    }

    @Test
    public void shouldReturnPitTimeIfAfterPitLap() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");
        ElapsedTime pitTime = new ElapsedTime("00:00:15.000");
        int pitLapNumber = 1;

        given(lap1.isCompleteAt(time)).willReturn(true);
        given(lap1.isPit()).willReturn(true);
        given(lap1.getLapNumber()).willReturn(pitLapNumber);
        given(lap1.getPitTime()).willReturn(pitTime);

        carData.setTime(time);

        assertThat(carData.getPitTime()).isEqualTo(pitTime);
    }

    @Test
    public void shouldReturnLapPitNumberIfAfterPitLap() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");
        ElapsedTime pitTime = new ElapsedTime("00:00:15.000");
        int pitLapNumber = 1;

        given(lap1.isCompleteAt(time)).willReturn(true);
        given(lap1.isPit()).willReturn(true);
        given(lap1.getLapNumber()).willReturn(pitLapNumber);
        given(lap1.getPitTime()).willReturn(pitTime);

        carData.setTime(time);

        assertThat(carData.getPitLapNumber()).isEqualTo(pitLapNumber);
    }








    @Test
    public void shouldReturnRetiredFalseIfNotRetired() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");

        carData.setTime(time);

        assertThat(carData.hasRetired()).isFalse();
    }

    @Test
    public void shouldReturnZeroRetiredTimeIfNotRetired() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");

        carData.setTime(time);

        assertThat(carData.getRetiredTime()).isEqualTo(new ElapsedTime());
    }

    @Test
    public void shouldReturnHasRetiredFalseIfBeforeRetiredOnCurrentLap() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");

        given(lap1.contains(time)).willReturn(true);
        given(lap1.isRetiredAt(time)).willReturn(false);

        carData.setTime(time);

        assertThat(carData.hasRetired()).isFalse();
    }

    @Test
    public void shouldReturnZeroRetiredTimeIfBeforeRetiredOnCurrentLap() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");

        given(lap1.contains(time)).willReturn(true);
        given(lap1.isRetiredAt(time)).willReturn(false);

        carData.setTime(time);

        assertThat(carData.getRetiredTime()).isEqualTo(new ElapsedTime());
    }

    @Test
    public void shouldReturnHasRetiredTrueIfAfterRetiredOnCurrentLap() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");

        given(lap1.contains(time)).willReturn(true);
        given(lap1.isRetired()).willReturn(true);
        given(lap1.isRetiredAt(time)).willReturn(true);

        carData.setTime(time);

        assertThat(carData.hasRetired()).isTrue();
    }

    @Test
    public void shouldReturnCurrentLapRetiredTimeIfAfterRetiredOnCurrentLap() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");
        ElapsedTime retiredTime = new ElapsedTime("00:00:10.000");

        given(lap1.contains(time)).willReturn(true);
        given(lap1.isRetired()).willReturn(true);
        given(lap1.isRetiredAt(time)).willReturn(true);
        given(lap1.getRetiredTime()).willReturn(retiredTime);

        carData.setTime(time);

        assertThat(carData.getRetiredTime()).isEqualTo(retiredTime);
    }

    @Test
    public void shouldReturnHasRetiredTrueIfAfterRetiredLap() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");
        ElapsedTime retiredTime = new ElapsedTime("00:00:15.000");

        given(lap1.isCompleteAt(time)).willReturn(true);
        given(lap1.isRetired()).willReturn(true);
        given(lap1.getRetiredTime()).willReturn(retiredTime);

        carData.setTime(time);

        assertThat(carData.hasRetired()).isTrue();
    }

    @Test
    public void shouldReturnRetiredTimeIfAfterRetiredLap() {
        ElapsedTime time = new ElapsedTime("00:00:00.000");
        ElapsedTime retiredTime = new ElapsedTime("00:00:15.000");

        given(lap1.isCompleteAt(time)).willReturn(true);
        given(lap1.isRetired()).willReturn(true);
        given(lap1.getRetiredTime()).willReturn(retiredTime);

        carData.setTime(time);

        assertThat(carData.getRetiredTime()).isEqualTo(retiredTime);
    }

}
