package uk.co.mruoc.race;

import java.math.BigDecimal;

public interface DistanceProvider {

    void add(String key, BigDecimal distance);

    BigDecimal getDistanceBetweenCheckpoints(int startCheckpointId, int endCheckpointId);

    int getNextCheckpointId(int checkpointId);

}
