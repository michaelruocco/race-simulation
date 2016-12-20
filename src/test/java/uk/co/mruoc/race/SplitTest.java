package uk.co.mruoc.race;

import org.junit.Test;
import uk.co.mruoc.race.model.Split;
import uk.co.mruoc.race.model.Split.SplitBuilder;
import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitTest {

    private static final int CAR_ID = 1;
    private static final int END_CHECKPOINT_ID = 2;
    private static final boolean RETIRED = false;
    private static final ElapsedTime START_TIME = new ElapsedTime("00:00:00.000");
    private static final ElapsedTime END_TIME = new ElapsedTime("00:01:00.000");
    private static final BigDecimal START_DISTANCE = BigDecimal.valueOf(200);
    private static final BigDecimal SPLIT_DISTANCE = BigDecimal.valueOf(300);

    private final SplitBuilder builder = new SplitBuilder()
            .setCarId(CAR_ID)
            .setEndCheckpointId(END_CHECKPOINT_ID)
            .setRetired(RETIRED)
            .setStartTime(START_TIME)
            .setEndTime(END_TIME)
            .setStartDistance(START_DISTANCE)
            .setSplitDistance(SPLIT_DISTANCE);

    private final Split split = builder.build();

    @Test
    public void shouldReturnStartTime() {
        assertThat(split.getStartTime()).isEqualTo(START_TIME);
    }

    @Test
    public void shouldReturnEndTime() {
        assertThat(split.getEndTime()).isEqualTo(END_TIME);
    }

    @Test
    public void shouldReturnEndCheckpointId() {
        assertThat(split.getEndCheckpointId()).isEqualTo(END_CHECKPOINT_ID);
    }

    @Test
    public void shouldContaiStartTime() {
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
    public void shouldNotContainTimeAfterEndTime() {
        assertThat(split.contains(END_TIME.add(1))).isFalse();
    }

    @Test
    public void shouldReturnSplitDistance() {
        assertThat(split.getDistance()).isEqualTo(SPLIT_DISTANCE);
    }

    @Test
    public void shouldReturnSplitDistanceAtGivenTime() {
        ElapsedTime halfTime = new ElapsedTime("00:00:30.000");

        assertThat(split.getSplitDistanceAt(halfTime)).isEqualTo(BigDecimal.valueOf(150.0));
    }

    @Test
    public void shouldReturnTotalDistanceAtGivenTime() {
        ElapsedTime halfTime = new ElapsedTime("00:00:30.000");

        assertThat(split.getTotalDistanceAt(halfTime)).isEqualTo(BigDecimal.valueOf(350.0));
    }

    @Test
    public void shouldReturnSpeedInMetersPerMillisecond() {
        ElapsedTime splitTime = END_TIME.subtract(START_TIME);
        BigDecimal speedInMetersPerMillisecond = SPLIT_DISTANCE.divide(BigDecimal.valueOf(splitTime.getTotalMillis()));

        assertThat(split.getSpeed()).isEqualTo(speedInMetersPerMillisecond);
    }

    @Test
    public void shouldReturnZeroSpeedIfRetired() {
        builder.setRetired(true);
        Split split = builder.build();

        assertThat(split.getSpeed()).isEqualTo(BigDecimal.ZERO);
    }

}
