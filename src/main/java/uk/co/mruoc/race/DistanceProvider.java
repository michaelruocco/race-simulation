package uk.co.mruoc.race;

public interface DistanceProvider {

    double getDistanceBetweenCheckpoints(int startCheckpointId, int endCheckpointId);

    int getNextCheckpointId(int checkpointId);

}
