package uk.co.mruoc.race;

import uk.co.mruoc.time.ElapsedTime;

public class DataLine {

    private static final char RETIRED = 'R';

    private final ElapsedTime time;
    private final int carId;
    private final char checkpointId;
    private final boolean queried;

    public DataLine(ElapsedTime time, int carId, char checkpointId, boolean queried) {
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

    public char getCheckpointId() {
        return checkpointId;
    }

    public boolean isQueried() {
        return queried;
    }

    public boolean isRetired() {
        return checkpointId == RETIRED;
    }

}
