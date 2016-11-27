package uk.co.mruoc.race;

import uk.co.mruoc.time.ElapsedTime;

public class DataLine {

    private final ElapsedTime time;
    private final int carId;
    private final int checkpointId;

    public DataLine(ElapsedTime time, int carId, int checkpointId) {
        this.time = time;
        this.carId = carId;
        this.checkpointId = checkpointId;
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

}
