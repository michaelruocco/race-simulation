package uk.co.mruoc.race;

public interface DistanceProvider {

    void add(String key, double distance);

    double getDistanceBetweenCheckpoints(int startCheckpointId, int endCheckpointId);

    int getNextCheckpointId(int checkpointId);

}
