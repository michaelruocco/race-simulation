package uk.co.mruoc.race.core;

import org.junit.Test;
import uk.co.mruoc.race.core.Split.SplitBuilder;
import uk.co.mruoc.time.ElapsedTime;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitsToLapsConverterTest {

    private final SplitsToLapsConverter splitsToLapsConverter = new SplitsToLapsConverter();

    @Test
    public void shouldConvertSplitsIntoLaps() {
        List<Split> splits = new ArrayList<>();
        splits.add(buildSplitWithEndCheckpointId(1));
        splits.add(buildSplitWithEndCheckpointId(2));
        splits.add(buildSplitWithEndCheckpointId(0));
        splits.add(buildSplitWithEndCheckpointId(1));
        splits.add(buildSplitWithEndCheckpointId(2));
        splits.add(buildSplitWithEndCheckpointId(0));

        List<Lap> laps = splitsToLapsConverter.toLaps(splits);

        assertThat(laps.size()).isEqualTo(2);
    }

    @Test
    public void shouldConvertSplitsIntoLapsIfLeftoverSplitsInclude() {
        List<Split> splits = new ArrayList<>();
        splits.add(buildSplitWithEndCheckpointId(1));
        splits.add(buildSplitWithEndCheckpointId(2));
        splits.add(buildSplitWithEndCheckpointId(0));
        splits.add(buildSplitWithEndCheckpointId(1));
        splits.add(buildSplitWithEndCheckpointId(2));

        List<Lap> laps = splitsToLapsConverter.toLaps(splits);

        assertThat(laps.size()).isEqualTo(2);
    }

    private Split buildSplitWithEndCheckpointId(int endCheckpointId) {
        return new SplitBuilder()
                .setEndCheckpointId(endCheckpointId)
                .setStartTime(new ElapsedTime())
                .setEndTime(new ElapsedTime())
                .build();
    }

}
