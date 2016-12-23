package uk.co.mruoc.race.model;

import uk.co.mruoc.time.ElapsedTime;

import static uk.co.mruoc.race.model.FileLine.*;

public class TestFileLineBuilder {

    private ElapsedTime time = new ElapsedTime();
    private int carId = 0;
    private int checkpointId = 0;
    private boolean queried = false;

    private FileLineBuilder builder = new FileLineBuilder();

    public TestFileLineBuilder() {
        builder = builder
                .setTime(time)
                .setCarId(carId)
                .setCheckpointId(checkpointId)
                .setQueried(queried);
    }

    public TestFileLineBuilder setCheckpointId(int checkpointId) {
        builder.setCheckpointId(checkpointId);
        return this;
    }

    public TestFileLineBuilder setCarId(int carId) {
        builder.setCarId(carId);
        return this;
    }

    public FileLine build() {
        return builder.build();
    }

}
