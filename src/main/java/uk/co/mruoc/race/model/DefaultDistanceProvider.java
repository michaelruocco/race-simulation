package uk.co.mruoc.race.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultDistanceProvider implements DistanceProvider {

    private static final Logger LOG = LogManager.getLogger(FileLineParser.class);

    private final Map<String, BigDecimal> distances = new LinkedHashMap<>();

    @Override
    public void add(String key, BigDecimal distance) {
        distances.put(key, distance);
    }

    @Override
    public BigDecimal getDistanceBetweenCheckpoints(int startCheckpointId, int endCheckpointId) {
        String key = toKey(startCheckpointId, endCheckpointId);
        if (distances.containsKey(key)) {
            BigDecimal distance = distances.get(key);
            LOG.debug("returning distance " + distance + " between checkpoints " + key);
            return distance;
        }

        LOG.info("no distance found between checkpoints " + key + " returning 0 ");
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal getDistanceToNextCheckpoint(int checkpointId) {
        int nextCheckpointId = getNextCheckpointId(checkpointId);
        return getDistanceBetweenCheckpoints(checkpointId, nextCheckpointId);
    }

    private int getNextCheckpointId(int checkpointId) {
        for (String key : distances.keySet())
            if (extractFirstCheckpointId(key) == checkpointId)
                return extractSecondCheckpointId(key);
        throw new NextCheckpointIdNotFoundException("next checkpoint id not found for checkpoint id " + checkpointId);
    }

    private int extractFirstCheckpointId(String key) {
        return extractCheckpointId(key, 0);
    }

    private int extractSecondCheckpointId(String key) {
        return extractCheckpointId(key, 1);
    }

    private int extractCheckpointId(String key, int index) {
        return Integer.parseInt(key.split("-")[index]);
    }

    private String toKey(int startCheckpointId, int endCheckpointId) {
        return startCheckpointId + "-" + endCheckpointId;
    }

}
