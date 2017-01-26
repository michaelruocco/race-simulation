package uk.co.mruoc.race.console;

import org.junit.Before;
import org.junit.Test;
import uk.co.mruoc.race.model.CarStats;
import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CarStatsFormatterTest {

    private static final int POSITION_INDEX = 0;
    private static final int CAR_ID_INDEX = 1;
    private static final int SPEED_INDEX = 2;
    private static final int LAP_NUMBER_INDEX = 3;
    private static final int TIME_DIFFERENCE_INDEX = 4;
    private static final int AVERAGE_LAP_SPEED_INDEX = 5;
    private static final int MAX_AVERAGE_LAP_SPEED_INDEX = 6;
    private static final int PIT_TIME_INDEX = 7;
    private static final int PIT_LAP_INDEX = 8;
    private static final int RETIRED_TIME_INDEX = 9;
    private static final int RETIRED_LAP_INDEX = 10;
    private static final int RETIRED_DISTANCE_INDEX = 11;

    private final CarStats stats = mock(CarStats.class);
    private final ElapsedTime timeDifference = new ElapsedTime();

    private final CarStatsFormatter converter = new CarStatsFormatter();

    @Before
    public void setUp() {
        given(stats.getTimeDifference()).willReturn(timeDifference);
    }

    @Test
    public void shouldConvertPosition() {
        int position = 3;
        given(stats.getPosition()).willReturn(position);

        List<String> values = converter.format(stats);

        assertThat(values.get(POSITION_INDEX)).isEqualTo(Integer.toString(position));
    }

    @Test
    public void shouldConvertCarId() {
        int carId = 1;
        given(stats.getCarId()).willReturn(carId);

        List<String> values = converter.format(stats);

        assertThat(values.get(CAR_ID_INDEX)).isEqualTo(Integer.toString(carId));
    }

    @Test
    public void shouldConvertSpeed() {
        BigDecimal speedInMetersPerMillisecond = BigDecimal.valueOf(0.03);
        given(stats.getSpeed()).willReturn(speedInMetersPerMillisecond);

        List<String> values = converter.format(stats);

        String expectedSpeedInKmPerHour = "108.00";
        assertThat(values.get(SPEED_INDEX)).isEqualTo(expectedSpeedInKmPerHour);
    }

    @Test
    public void shouldConvertLapNumber() {
        int lapNumber = 7;
        given(stats.getLapNumber()).willReturn(lapNumber);

        List<String> values = converter.format(stats);

        assertThat(values.get(LAP_NUMBER_INDEX)).isEqualTo(Integer.toString(lapNumber));
    }

    @Test
    public void shouldConvertTimeDifference() {
        List<String> values = converter.format(stats);

        assertThat(values.get(TIME_DIFFERENCE_INDEX)).isEqualTo(timeDifference.toString());
    }

    @Test
    public void shouldConvertToLeaderIfInPolePosition() {
        given(stats.getPosition()).willReturn(1);

        List<String> values = converter.format(stats);

        assertThat(values.get(TIME_DIFFERENCE_INDEX)).isEqualTo("Leader");
    }

    @Test
    public void shouldConvertAverageLapSpeed() {
        BigDecimal speedInMetersPerMillisecond = BigDecimal.valueOf(0.03);
        given(stats.getAverageLapSpeed()).willReturn(speedInMetersPerMillisecond);

        List<String> values = converter.format(stats);

        String expectedSpeedInKmPerHour = "108.00";
        assertThat(values.get(AVERAGE_LAP_SPEED_INDEX)).isEqualTo(expectedSpeedInKmPerHour);
    }

    @Test
    public void shouldNotConvertMaxAverageLapSpeedIfNoLapsCompleted() {
        given(stats.getLapNumber()).willReturn(1);

        List<String> values = converter.format(stats);

        assertThat(values.get(MAX_AVERAGE_LAP_SPEED_INDEX)).isEqualTo("-");
    }

    @Test
    public void shouldConvertMaxAverageLapSpeed() {
        BigDecimal speedInMetersPerMillisecond = BigDecimal.valueOf(0.03);
        given(stats.getLapNumber()).willReturn(2);
        given(stats.getMaximumAverageLapSpeed()).willReturn(speedInMetersPerMillisecond);

        List<String> values = converter.format(stats);

        String expectedSpeedInKmPerHour = "108.00";
        assertThat(values.get(MAX_AVERAGE_LAP_SPEED_INDEX)).isEqualTo(expectedSpeedInKmPerHour);
    }

    @Test
    public void shouldConvertPitTimeWhenNotPitted() {
        List<String> values = converter.format(stats);

        assertThat(values.get(PIT_TIME_INDEX)).isEqualTo("-");
    }

    @Test
    public void shouldConvertPitLapWhenNotPitted() {
        List<String> values = converter.format(stats);

        assertThat(values.get(PIT_LAP_INDEX)).isEqualTo("-");
    }

    @Test
    public void shouldConvertPitTime() {
        ElapsedTime pitTime = new ElapsedTime();
        given(stats.hasPitted()).willReturn(true);
        given(stats.getPitTime()).willReturn(pitTime);

        List<String> values = converter.format(stats);

        assertThat(values.get(PIT_TIME_INDEX)).isEqualTo(pitTime.toString());
    }

    @Test
    public void shouldConvertPitLap() {
        int pitLapNumber = 5;
        given(stats.hasPitted()).willReturn(true);
        given(stats.getPitTime()).willReturn(new ElapsedTime());
        given(stats.getPitLapNumber()).willReturn(5);

        List<String> values = converter.format(stats);

        assertThat(values.get(PIT_LAP_INDEX)).isEqualTo(Integer.toString(pitLapNumber));
    }

    @Test
    public void shouldConvertRetiredTimeWhenNotRetired() {
        List<String> values = converter.format(stats);

        assertThat(values.get(RETIRED_TIME_INDEX)).isEqualTo("-");
    }

    @Test
    public void shouldConvertRetiredLapWhenNotRetired() {
        List<String> values = converter.format(stats);

        assertThat(values.get(RETIRED_LAP_INDEX)).isEqualTo("-");
    }

    @Test
    public void shouldConvertRetiredDistanceWhenNotRetired() {
        List<String> values = converter.format(stats);

        assertThat(values.get(RETIRED_DISTANCE_INDEX)).isEqualTo("-");
    }

    @Test
    public void shouldConvertRetiredTime() {
        ElapsedTime retiredTime = new ElapsedTime();
        given(stats.hasRetired()).willReturn(true);
        given(stats.getRetiredTime()).willReturn(retiredTime);

        List<String> values = converter.format(stats);

        assertThat(values.get(RETIRED_TIME_INDEX)).isEqualTo(retiredTime.toString());
    }

    @Test
    public void shouldConvertRetiredLap() {
        int lapNumber = 2;
        given(stats.hasRetired()).willReturn(true);
        given(stats.getRetiredTime()).willReturn(new ElapsedTime());
        given(stats.getLapNumber()).willReturn(lapNumber);

        List<String> values = converter.format(stats);

        assertThat(values.get(RETIRED_LAP_INDEX)).isEqualTo(Integer.toString(lapNumber));
    }

    @Test
    public void shouldConvertRetiredDistance() {
        BigDecimal distance = BigDecimal.valueOf(300.123);
        given(stats.hasRetired()).willReturn(true);
        given(stats.getRetiredTime()).willReturn(new ElapsedTime());
        given(stats.getDistance()).willReturn(distance);

        List<String> values = converter.format(stats);

        assertThat(values.get(RETIRED_DISTANCE_INDEX)).isEqualTo(distance.setScale(2, RoundingMode.HALF_UP).toString());
    }

}
