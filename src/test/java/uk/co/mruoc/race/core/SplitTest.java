package uk.co.mruoc.race.core;

import org.junit.Test;
import uk.co.mruoc.race.core.Split.SplitBuilder;
import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;
import static java.math.MathContext.*;
import static java.math.RoundingMode.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SplitTest {

    private static final int CAR_ID = 1;
    private static final int END_CHECKPOINT_ID = 2;
    private static final boolean RETIRED = false;
    private static final boolean PIT = true;
    private static final ElapsedTime START_TIME = new ElapsedTime("00:00:00.000");
    private static final ElapsedTime END_TIME = new ElapsedTime("00:01:00.000");
    private static final ElapsedTime HALF_TIME = new ElapsedTime("00:00:30.000");
    private static final BigDecimal START_DISTANCE = valueOf(200);
    private static final BigDecimal SPLIT_DISTANCE = valueOf(300);

    private final SplitBuilder builder = new SplitBuilder()
            .setCarId(CAR_ID)
            .setEndCheckpointId(END_CHECKPOINT_ID)
            .setRetired(RETIRED)
            .setPit(PIT)
            .setStartTime(START_TIME)
            .setEndTime(END_TIME)
            .setStartDistance(START_DISTANCE)
            .setSplitDistance(SPLIT_DISTANCE);

    private final Split split = builder.build();

    @Test
    public void shouldReturnCarId() {
        assertThat(split.getCarId()).isEqualTo(CAR_ID);
    }

    @Test
    public void shouldReturnStartTime() {
        assertThat(split.getStartTime()).isEqualTo(START_TIME);
    }

    @Test
    public void shouldReturnEndTime() {
        assertThat(split.getEndTime()).isEqualTo(END_TIME);
    }

    @Test
    public void shouldReturnTime() {
        assertThat(split.getTime()).isEqualTo(END_TIME.subtract(START_TIME));
    }

    @Test
    public void shouldReturnIsRetired() {
        assertThat(split.isRetired()).isEqualTo(RETIRED);
    }

    @Test
    public void shouldReturnIsPit() {
        assertThat(split.isPit()).isEqualTo(PIT);
    }

    @Test
    public void shouldReturnEndCheckpointId() {
        assertThat(split.getEndCheckpointId()).isEqualTo(END_CHECKPOINT_ID);
    }

    @Test
    public void shouldContainStartTime() {
        assertThat(split.contains(START_TIME)).isTrue();
    }

    @Test
    public void shouldContainEndTime() {
        assertThat(split.contains(END_TIME)).isTrue();
    }

    @Test
    public void shouldContainTimeBetweenStartAndEndTime() {
        assertThat(split.contains(START_TIME.add(1))).isTrue();
    }

    @Test
    public void shouldNotContainTimeBeforeStartTime() {
        ElapsedTime startTime = new ElapsedTime("00:00:00.001");
        builder.setStartTime(startTime);
        Split split = builder.build();

        assertThat(split.contains(startTime.subtract(1))).isFalse();
    }

    @Test
    public void isCompleteAtShouldReturnTrueIfTimeEqualsEndTime() {
        ElapsedTime endTime = new ElapsedTime("00:00:00.001");
        builder.setEndTime(endTime);
        Split split = builder.build();

        assertThat(split.isCompleteAt(endTime)).isTrue();
    }

    @Test
    public void isCompleteAtShouldReturnTrueIfTimeAfterEndTime() {
        ElapsedTime endTime = new ElapsedTime("00:00:00.001");
        builder.setEndTime(endTime);
        Split split = builder.build();

        assertThat(split.isCompleteAt(endTime.add(1))).isTrue();
    }

    @Test
    public void isCompleteAtShouldReturnFalseIfTimeBeforeEndTime() {
        ElapsedTime endTime = new ElapsedTime("00:00:00.001");
        builder.setEndTime(endTime);
        Split split = builder.build();

        assertThat(split.isCompleteAt(endTime.subtract(1))).isFalse();
    }

    @Test
    public void shouldNotContainTimeAfterEndTime() {
        assertThat(split.contains(END_TIME.add(1))).isFalse();
    }

    @Test
    public void shouldReturnStartDistance() {
        assertThat(split.getStartDistance()).isEqualTo(START_DISTANCE);
    }

    @Test
    public void shouldReturnSplitDistance() {
        assertThat(split.getDistance()).isEqualTo(SPLIT_DISTANCE);
    }

    @Test
    public void shouldReturnZeroSplitDistanceIfNotSet() {
        builder.setSplitDistance(null);

        Split noDistanceSplit = builder.build();

        assertThat(noDistanceSplit.getDistance()).isEqualTo(ZERO);
    }

    @Test
    public void shouldReturnZeroSpeedAtZeroTime() {
        SplitStats stats = split.getStatsAt(new ElapsedTime());

        assertThat(stats.getSpeed()).isEqualTo(ZERO);
    }

    @Test
    public void shouldReturnSplitDistanceAtGivenTime() {
        SplitStats stats = split.getStatsAt(HALF_TIME);

        assertThat(stats.getDistance()).isEqualTo(valueOf(150.0));
    }

    @Test
    public void shouldReturnTotalDistanceAtGivenTime() {
        SplitStats stats = split.getStatsAt(HALF_TIME);

        assertThat(stats.getTotalDistance()).isEqualTo(valueOf(350.0));
    }

    @Test
    public void shouldReturnAdjustedSplitDistanceAtGivenTimeIfRetired() {
        Split split = builder.setRetired(true).build();
        BigDecimal expectedDistance = BigDecimal.valueOf(30.0).setScale(2, HALF_UP);

        SplitStats stats = split.getStatsAt(HALF_TIME);

        assertThat(stats.getDistance()).isEqualTo(expectedDistance);
    }

    @Test
    public void shouldReturnAdjustedTotalDistanceAtGivenTimeIfRetired() {
        Split split = builder.setRetired(true).build();
        BigDecimal expectedDistance = BigDecimal.valueOf(230.0).setScale(2, HALF_UP);

        SplitStats stats = split.getStatsAt(HALF_TIME);

        assertThat(stats.getTotalDistance()).isEqualTo(expectedDistance);
    }

    @Test
    public void shouldReturnSpeedInMetersPerMillisecond() {
        ElapsedTime splitTime = END_TIME.subtract(START_TIME);
        BigDecimal speedInMetersPerMillisecond = SPLIT_DISTANCE.divide(valueOf(splitTime.getTotalMillis()), DECIMAL32);

        SplitStats stats = split.getStatsAt(HALF_TIME);

        assertThat(stats.getSpeed()).isEqualTo(speedInMetersPerMillisecond);
    }

    @Test
    public void shouldReturnZeroSpeedIfRetired() {
        builder.setRetired(true);
        Split split = builder.build();

        SplitStats stats = split.getStatsAt(HALF_TIME);

        assertThat(stats.getSpeed()).isEqualTo(ZERO);
    }

}
