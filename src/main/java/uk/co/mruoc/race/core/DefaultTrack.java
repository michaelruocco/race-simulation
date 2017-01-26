package uk.co.mruoc.race.core;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class DefaultTrack extends DefaultDistanceProvider implements Track {

    private final List<Integer> pitCheckpoints = Arrays.asList(4, 5);

    public DefaultTrack() {
        add("0-1", BigDecimal.valueOf(800));
        add("1-2", BigDecimal.valueOf(1200));
        add("2-3", BigDecimal.valueOf(300));
        add("3-6", BigDecimal.valueOf(700));
        add("6-7", BigDecimal.valueOf(800));
        add("7-8", BigDecimal.valueOf(1200));
        add("8-9", BigDecimal.valueOf(400));
        add("9-0", BigDecimal.valueOf(600));

        add("3-4", BigDecimal.valueOf(200));
        add("4-5", BigDecimal.valueOf(200));
        add("5-6", BigDecimal.valueOf(500));
    }

    @Override
    public boolean isPit(int startCheckpointId, int endCheckpointId) {
        return pitCheckpoints.contains(startCheckpointId) && pitCheckpoints.contains(endCheckpointId);
    }

}
