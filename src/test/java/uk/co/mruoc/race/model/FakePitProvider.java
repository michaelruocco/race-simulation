package uk.co.mruoc.race.model;

public class FakePitProvider implements PitProvider {

    private boolean pit;

    public void setPit(boolean pit) {
        this.pit = pit;
    }

    @Override
    public boolean isPit(int startCheckpointId, int endCheckpointId) {
        return pit;
    }

}
