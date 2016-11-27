package uk.co.mruoc.race;

import uk.co.mruoc.time.ElapsedTime;

public class TestDataLineBuilder {

    private ElapsedTime time = new ElapsedTime();
    private int carId = 0;
    private char checkpointId = '0';
    private boolean queried = false;

    public TestDataLineBuilder withCheckpointId(char checkpointId) {
        this.checkpointId = checkpointId;
        return this;
    }

    public DataLine build() {
        return new DataLine(time, carId, checkpointId, queried);
    }

}
