package uk.co.mruoc.race.core;

import java.util.ArrayList;
import java.util.List;

public class SplitsToLapsConverter {

    public List<Lap> toLaps(List<Split> splits) {
        List<Lap> laps = new ArrayList<>();
        List<Split> lapSplits = new ArrayList<>();

        for (Split split : splits) {
            lapSplits.add(split);
            if (split.getEndCheckpointId() == 0) {
                laps.add(new Lap(toLapNumber(laps), lapSplits));
                lapSplits = new ArrayList<>();
            }
        }

        if (!lapSplits.isEmpty())
            laps.add(new Lap(toLapNumber(laps), lapSplits));

        return laps;
    }

    private static int toLapNumber(List<Lap> laps) {
        return laps.size() + 1;
    }

}
