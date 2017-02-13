package uk.co.mruoc.race.gui;

import java.util.ArrayList;
import java.util.List;

public class CheckpointScaler {

    public static List<Checkpoint> scale(List<Checkpoint> checkpoints, ScaleParams params) {
        List<Checkpoint> newCheckpoints = new ArrayList<>();
        for (Checkpoint checkpoint : checkpoints)
            newCheckpoints.add(checkpoint.scale(params));
        return newCheckpoints;
    }

}
