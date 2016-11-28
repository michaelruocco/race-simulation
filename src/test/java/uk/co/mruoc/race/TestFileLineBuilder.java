package uk.co.mruoc.race;

import uk.co.mruoc.time.ElapsedTime;

public class TestFileLineBuilder {

    private ElapsedTime time = new ElapsedTime();
    private int carId = 0;
    private int checkpointId = '0';
    private boolean queried = false;

    public TestFileLineBuilder withCheckpointId(int checkpointId) {
        this.checkpointId = checkpointId;
        return this;
    }

    public TestFileLineBuilder withCarId(int carId) {
        this.carId = carId;
        return this;
    }

    public FileLine build() {
        return new FileLine(time, carId, checkpointId, queried);
    }

}
