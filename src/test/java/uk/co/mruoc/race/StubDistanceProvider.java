package uk.co.mruoc.race;

public class StubDistanceProvider implements DistanceProvider {

    private final double distance;

    public StubDistanceProvider(double distance) {
        this.distance = distance;
    }

    @Override
    public double getDistanceBetweenCheckpoints(int startCheckpointId, int endCheckpointId) {
        return distance;
    }

    @Override
    public int getNextCheckpointId(int checkpointId) {
        return 0;
    }

}
