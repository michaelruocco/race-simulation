package uk.co.mruoc.race.core;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class FileLinesToSplitsConverterTest {

    private final TestFileLineBuilder builder = new TestFileLineBuilder();

    private final DistanceProvider distanceProvider = new DefaultDistanceProvider();
    private final FakePitProvider pitProvider = new FakePitProvider();
    private final FileLinesToSplitsConverter converter = new FileLinesToSplitsConverter(distanceProvider, pitProvider);

    @Test
    public void shouldConvertOneLineToZeroSplits() {
        List<FileLine> lines = Collections.singletonList(builder.build());

        List<Split> splits = converter.toSplits(lines);

        assertThat(splits.isEmpty()).isTrue();
    }

    @Test
    public void shouldConvertTwoLinesToOneSplit() {
        List<FileLine> lines = new ArrayList<>();
        lines.add(builder.build());
        lines.add(builder.build());

        List<Split> splits = converter.toSplits(lines);

        assertThat(splits.size()).isEqualTo(1);
    }

    @Test
    public void shouldConvertThreeLinesToTwoSplits() {
        List<FileLine> lines = new ArrayList<>();
        lines.add(builder.build());
        lines.add(builder.build());
        lines.add(builder.build());

        List<Split> splits = converter.toSplits(lines);

        assertThat(splits.size()).isEqualTo(2);
    }

    @Test
    public void shouldPopulateCarId() {
        int carId = 3;
        List<FileLine> lines = new ArrayList<>();
        lines.add(builder.setCarId(carId).build());
        lines.add(builder.build());

        List<Split> splits = converter.toSplits(lines);

        Split split = splits.get(0);
        assertThat(split.getCarId()).isEqualTo(carId);
    }

    @Test
    public void shouldPopulateEndCheckpointId() {
        int endCheckpointId = 8;
        List<FileLine> lines = new ArrayList<>();
        lines.add(builder.build());
        lines.add(builder.setCheckpointId(endCheckpointId).build());

        List<Split> splits = converter.toSplits(lines);

        Split split = splits.get(0);
        assertThat(split.getEndCheckpointId()).isEqualTo(endCheckpointId);
    }

    @Test
    public void shouldPopulateRetiredFlag() {
        distanceProvider.add("0-1", BigDecimal.ZERO);
        List<FileLine> lines = new ArrayList<>();
        lines.add(builder.build());
        lines.add(builder.setCheckpointId(-1).build());

        List<Split> splits = converter.toSplits(lines);

        Split split = splits.get(0);
        assertThat(split.isRetired()).isTrue();
    }

    @Test
    public void shouldUseDistanceToNextCheckpointIfRetired() {
        BigDecimal distance = BigDecimal.valueOf(300);
        distanceProvider.add("3-4", distance);
        List<FileLine> lines = new ArrayList<>();
        lines.add(builder.setCheckpointId(3).build());
        lines.add(builder.setCheckpointId(-1).build());

        List<Split> splits = converter.toSplits(lines);

        Split split = splits.get(0);
        assertThat(split.getDistance()).isEqualTo(distance);
    }

    @Test
    public void shouldPopulateStartTime() {
        ElapsedTime startTime = new ElapsedTime("00:00:30.000");
        List<FileLine> lines = new ArrayList<>();
        lines.add(builder.setTime(startTime).build());
        lines.add(builder.build());

        List<Split> splits = converter.toSplits(lines);

        Split split = splits.get(0);
        assertThat(split.getStartTime()).isEqualTo(startTime);
    }

    @Test
    public void shouldPopulateEndTime() {
        ElapsedTime endTime = new ElapsedTime("00:00:30.000");
        List<FileLine> lines = new ArrayList<>();
        lines.add(builder.build());
        lines.add(builder.setTime(endTime).build());

        List<Split> splits = converter.toSplits(lines);

        Split split = splits.get(0);
        assertThat(split.getEndTime()).isEqualTo(endTime);
    }

    @Test
    public void shouldPopulateSplitDistance() {
        BigDecimal distance1 = BigDecimal.valueOf(200);
        BigDecimal distance2 = BigDecimal.valueOf(300);
        distanceProvider.add("0-1", distance1);
        distanceProvider.add("1-2", distance2);

        List<FileLine> lines = new ArrayList<>();
        lines.add(builder.setCheckpointId(0).build());
        lines.add(builder.setCheckpointId(1).build());
        lines.add(builder.setCheckpointId(2).build());

        List<Split> splits = converter.toSplits(lines);

        assertThat(splits.get(0).getDistance()).isEqualTo(distance1);
        assertThat(splits.get(1).getDistance()).isEqualTo(distance2);
    }

    @Test
    public void firstSplitStartDistanceShouldBeZero() {
        List<FileLine> lines = new ArrayList<>();
        lines.add(builder.build());
        lines.add(builder.build());

        List<Split> splits = converter.toSplits(lines);

        Split split = splits.get(0);
        assertThat(split.getStartDistance()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void splitStartDistanceShouldEqualTotalOfPreviousSplitDistances() {
        BigDecimal distance1 = BigDecimal.valueOf(200);
        BigDecimal distance2 = BigDecimal.valueOf(300);
        distanceProvider.add("0-1", distance1);
        distanceProvider.add("1-2", distance2);

        List<FileLine> lines = new ArrayList<>();
        lines.add(builder.setCheckpointId(0).build());
        lines.add(builder.setCheckpointId(1).build());
        lines.add(builder.setCheckpointId(2).build());
        lines.add(builder.setCheckpointId(3).build());

        List<Split> splits = converter.toSplits(lines);

        assertThat(splits.get(0).getStartDistance()).isEqualTo(BigDecimal.ZERO);
        assertThat(splits.get(1).getStartDistance()).isEqualTo(distance1);
        assertThat(splits.get(2).getStartDistance()).isEqualTo(distance1.add(distance2));
    }

    @Test
    public void shouldNotBePitIfDoesNotContainPitCheckpoints() {
        List<FileLine> lines = new ArrayList<>();
        lines.add(builder.setCheckpointId(0).build());
        lines.add(builder.setCheckpointId(1).build());
        pitProvider.setPit(false);

        List<Split> splits = converter.toSplits(lines);

        assertThat(splits.get(0).isPit()).isFalse();
    }

    @Test
    public void shouldBePitIfContainsPitCheckpoints() {
        List<FileLine> lines = new ArrayList<>();
        lines.add(builder.setCheckpointId(4).build());
        lines.add(builder.setCheckpointId(5).build());
        pitProvider.setPit(true);

        List<Split> splits = converter.toSplits(lines);

        assertThat(splits.get(0).isPit()).isTrue();
    }

}
