package uk.co.mruoc.race.model;

import java.math.BigDecimal;

public interface DistanceProvider {

    void add(String key, BigDecimal distance);

    BigDecimal getDistanceBetweenCheckpoints(int startCheckpointId, int endCheckpointId);

    BigDecimal getDistanceToNextCheckpoint(int checkpointId);

}
