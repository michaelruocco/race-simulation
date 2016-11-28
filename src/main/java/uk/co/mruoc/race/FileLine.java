package uk.co.mruoc.race;

import uk.co.mruoc.time.ElapsedTime;

public class FileLine {

    private static final int RETIRED = -1;

    private final ElapsedTime time;
    private final int carId;
    private final int checkpointId;
    private final boolean queried;

    public FileLine(ElapsedTime time, int carId, int checkpointId, boolean queried) {
        this.time = time;
        this.carId = carId;
        this.checkpointId = checkpointId;
        this.queried = queried;
    }

    public ElapsedTime getTime() {
        return time;
    }

    public int getCarId() {
        return carId;
    }

    public int getCheckpointId() {
        return checkpointId;
    }

    public boolean isQueried() {
        return queried;
    }

    public boolean isRetired() {
        return checkpointId == RETIRED;
    }

}
