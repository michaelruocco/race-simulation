package uk.co.mruoc.race;

import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultDistanceProvider implements DistanceProvider {

    private final Map<String, Double> distances = new LinkedHashMap<>();

    public DefaultDistanceProvider() {
        distances.put("0-1", 800d);
        distances.put("1-2", 1200d);
        distances.put("2-3", 300d);
        distances.put("3-6", 700d);
        distances.put("6-7", 800d);
        distances.put("7-8", 1200d);
        distances.put("8-9", 400d);
        distances.put("9-0", 600d);

        distances.put("3-4", 200d);
        distances.put("4-5", 200d);
        distances.put("5-6", 500d);
    }

    @Override
    public double getDistanceBetweenCheckpoints(int startCheckpointId, int endCheckpointId) {
        String key = toKey(startCheckpointId, endCheckpointId);
        return distances.get(key);
    }

    @Override
    public int getNextCheckpointId(int checkpointId) {
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
