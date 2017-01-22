package uk.co.mruoc.race.model;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.mruoc.race.model.Split.*;

public class LapTest {

    private static final int LAP_NUMBER = 3;

    @Test
    public void shouldReturnLapNumber() {
        Lap lap = new Lap(LAP_NUMBER);

        assertThat(lap.getLapNumber()).isEqualTo(LAP_NUMBER);
    }

    @Test
    public void shouldReturnZeroStartTimeIfNoSplits() {
        Lap lap = new Lap(LAP_NUMBER);

        assertThat(lap.getStartTime()).isEqualTo(new ElapsedTime("00:00:00.000"));
    }

    @Test
    public void shouldReturnZeroEndTimeIfNoSplits() {
        Lap lap = new Lap(LAP_NUMBER);

        assertThat(lap.getEndTime()).isEqualTo(new ElapsedTime("00:00:00.000"));
    }

    @Test
    public void shouldReturnStartTimeOfFirstSplit() {
        ElapsedTime startTime = new ElapsedTime("00:00:00.000");
        Split split = new SplitBuilder()
                .setStartTime(startTime)
                .setEndTime(new ElapsedTime("00:00:30.000"))
                .setSplitDistance(BigDecimal.valueOf(0))
                .build();

        Lap lap = new Lap(LAP_NUMBER, split);

        assertThat(lap.getStartTime()).isEqualTo(startTime);
    }

    @Test
    public void shouldReturnEndTimeOfSingleSplit() {
        ElapsedTime endTime = new ElapsedTime("00:00:30.000");
        Split split = new SplitBuilder()
                .setStartTime(new ElapsedTime("00:00:00.000"))
                .setEndTime(endTime)
                .setSplitDistance(BigDecimal.valueOf(0))
                .build();

        Lap lap = new Lap(LAP_NUMBER, split);

        assertThat(lap.getEndTime()).isEqualTo(endTime);
    }

    @Test
    public void shouldReturnEndTimeOfLastSplit() {
        ElapsedTime endTime = new ElapsedTime("00:00:50.000");
        Split split1 = new SplitBuilder()
                .setStartTime(new ElapsedTime("00:00:00.000"))
                .setEndTime(new ElapsedTime("00:00:30.000"))
                .setSplitDistance(BigDecimal.valueOf(0))
                .build();

        Split split2 = new SplitBuilder()
                .setStartTime(new ElapsedTime("00:00:30.001"))
                .setEndTime(endTime)
                .setSplitDistance(BigDecimal.valueOf(0))
                .build();

        Lap lap = new Lap(LAP_NUMBER, split1, split2);

        assertThat(lap.getEndTime()).isEqualTo(endTime);
    }

    @Test
    public void shouldContainTimesWithinLap() {
        Split split1 = new SplitBuilder()
                .setStartTime(new ElapsedTime("00:00:10.000"))
                .setEndTime(new ElapsedTime("00:00:30.000"))
                .setSplitDistance(BigDecimal.valueOf(0))
                .build();

        Split split2 = new SplitBuilder()
                .setStartTime(new ElapsedTime("00:00:30.001"))
                .setEndTime(new ElapsedTime("00:00:50.000"))
                .setSplitDistance(BigDecimal.valueOf(0))
                .build();

        Lap lap = new Lap(LAP_NUMBER, split1, split2);

        assertThat(lap.contains(new ElapsedTime("00:00:09.999"))).isFalse();
        assertThat(lap.contains(new ElapsedTime("00:00:10.000"))).isTrue();
        assertThat(lap.contains(new ElapsedTime("00:00:30.000"))).isTrue();
        assertThat(lap.contains(new ElapsedTime("00:00:50.000"))).isTrue();
        assertThat(lap.contains(new ElapsedTime("00:00:50.001"))).isFalse();
    }

    @Test
    public void shouldReturnAverageLapSpeedForGivenTime() {
        Split split1 = new SplitBuilder()
                .setStartTime(new ElapsedTime("00:00:10.000"))
                .setEndTime(new ElapsedTime("00:00:30.000"))
                .setStartDistance(BigDecimal.ZERO)
                .setSplitDistance(BigDecimal.valueOf(200))
                .build();

        Split split2 = new SplitBuilder()
                .setStartTime(new ElapsedTime("00:00:30.001"))
                .setEndTime(new ElapsedTime("00:00:50.000"))
                .setStartDistance(BigDecimal.valueOf(200))
                .setSplitDistance(BigDecimal.valueOf(200))
                .build();

        Lap lap = new Lap(LAP_NUMBER, split1, split2);
        LapStats lapStats = lap.getStatsAt(new ElapsedTime("00:00:30.000"));

        assertThat(lapStats.getAverageLapSpeed()).isEqualTo(BigDecimal.valueOf(0.01));
    }

    @Test
    public void shouldReturnAverageLapSpeedForGivenTimeAfterEndOfLap() {
        Split split1 = new SplitBuilder()
                .setStartTime(new ElapsedTime("00:00:10.000"))
                .setEndTime(new ElapsedTime("00:00:30.000"))
                .setStartDistance(BigDecimal.ZERO)
                .setSplitDistance(BigDecimal.valueOf(200))
                .build();

        Split split2 = new SplitBuilder()
                .setStartTime(new ElapsedTime("00:00:30.001"))
                .setEndTime(new ElapsedTime("00:00:50.000"))
                .setStartDistance(BigDecimal.valueOf(200))
                .setSplitDistance(BigDecimal.valueOf(400))
                .build();

        Lap lap = new Lap(LAP_NUMBER, split1, split2);
        LapStats lapStats = lap.getStatsAt(new ElapsedTime("00:00:50.001"));

        assertThat(lapStats.getAverageLapSpeed()).isEqualTo(BigDecimal.valueOf(0.015));
    }

    @Test
    public void shouldReturnAverageLapSpeedForWholeLap() {
        Split split1 = new SplitBuilder()
                .setStartTime(new ElapsedTime("00:00:10.000"))
                .setEndTime(new ElapsedTime("00:00:30.000"))
                .setStartDistance(BigDecimal.ZERO)
                .setSplitDistance(BigDecimal.valueOf(200))
                .build();

        Split split2 = new SplitBuilder()
                .setStartTime(new ElapsedTime("00:00:30.001"))
                .setEndTime(new ElapsedTime("00:00:50.000"))
                .setStartDistance(BigDecimal.valueOf(200))
                .setSplitDistance(BigDecimal.valueOf(400))
                .build();

        Lap lap = new Lap(LAP_NUMBER, split1, split2);

        assertThat(lap.getWholeAverageLapSpeed()).isEqualTo(BigDecimal.valueOf(0.015));
    }

    @Test
    public void shouldReturnCompleteIfAfterEndTime() {
        Split split1 = new SplitBuilder()
                .setStartTime(new ElapsedTime("00:00:10.000"))
                .setEndTime(new ElapsedTime("00:00:30.000"))
                .setStartDistance(BigDecimal.ZERO)
                .setSplitDistance(BigDecimal.valueOf(200))
                .build();

        Split split2 = new SplitBuilder()
                .setStartTime(new ElapsedTime("00:00:30.001"))
                .setEndTime(new ElapsedTime("00:00:50.000"))
                .setStartDistance(BigDecimal.valueOf(200))
                .setSplitDistance(BigDecimal.valueOf(400))
                .build();

        Lap lap = new Lap(LAP_NUMBER, split1, split2);

        assertThat(lap.isCompleteAt(new ElapsedTime("00:00:50.001"))).isTrue();
        assertThat(lap.isCompleteAt(new ElapsedTime("00:00:50.000"))).isTrue();
        assertThat(lap.isCompleteAt(new ElapsedTime("00:00:49.999"))).isFalse();
    }

    @Test
    public void shouldReturnFalseIfNotRetired() {
        Lap lap = new Lap(LAP_NUMBER);

        assertThat(lap.isRetired()).isFalse();
    }

    @Test
    public void shouldReturnTrueIfRetired() {
        Split split1 = new SplitBuilder()
                .setRetired(true)
                .setStartTime(new ElapsedTime("00:00:10.000"))
                .setEndTime(new ElapsedTime("00:00:30.000"))
                .build();

        Lap lap = new Lap(LAP_NUMBER, split1);

        assertThat(lap.isRetired()).isTrue();
    }

    @Test
    public void shouldReturnFalseIfNotPit() {
        Lap lap = new Lap(LAP_NUMBER);

        assertThat(lap.isPit()).isFalse();
    }

    @Test
    public void shouldReturnTrueIfPit() {
        Split split1 = new SplitBuilder()
                .setPit(true)
                .setStartTime(new ElapsedTime("00:00:10.000"))
                .setEndTime(new ElapsedTime("00:00:30.000"))
                .build();

        Lap lap = new Lap(LAP_NUMBER, split1);

        assertThat(lap.isPit()).isTrue();
    }

}
