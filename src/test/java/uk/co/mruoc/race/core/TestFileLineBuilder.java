package uk.co.mruoc.race.core;

import uk.co.mruoc.time.ElapsedTime;

import static uk.co.mruoc.race.core.FileLine.*;

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

    public TestFileLineBuilder setTime(ElapsedTime time) {
        builder.setTime(time);
        return this;
    }

    public TestFileLineBuilder setQueried(boolean queried) {
        builder.setQueried(queried);
        return this;
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
