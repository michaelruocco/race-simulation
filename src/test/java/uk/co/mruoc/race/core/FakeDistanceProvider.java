package uk.co.mruoc.race.core;

import java.math.BigDecimal;

public class FakeDistanceProvider implements DistanceProvider {

    @Override
    public void add(String key, BigDecimal distance) {

    }

    @Override
    public BigDecimal getDistanceBetweenCheckpoints(int startCheckpointId, int endCheckpointId) {
        return null;
    }

    @Override
    public BigDecimal getDistanceToNextCheckpoint(int checkpointId) {
        return null;
    }
}
