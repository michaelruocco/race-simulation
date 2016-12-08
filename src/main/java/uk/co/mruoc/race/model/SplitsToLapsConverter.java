package uk.co.mruoc.race.model;

import java.util.ArrayList;
import java.util.List;

public class SplitsToLapsConverter {

    public List<Lap> toLaps(List<Split> splits) {
        int lapNumber = 1;
        List<Lap> laps = new ArrayList<>();
        List<Split> lapSplits = new ArrayList<>();
        for (Split split : splits) {
            lapSplits.add(split);
            if (split.getEndCheckpointId() == 0) {
                laps.add(new Lap(lapNumber, lapSplits));
                lapSplits = new ArrayList<>();
                lapNumber++;
            }
        }

        if (!lapSplits.isEmpty())
            laps.add(new Lap(lapNumber, lapSplits));

        return laps;
    }

}
