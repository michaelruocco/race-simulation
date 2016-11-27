package uk.co.mruoc.race;

import uk.co.mruoc.time.ElapsedTime;

public class DataLine {

    private final ElapsedTime time;
    private final int carId;

    public DataLine(ElapsedTime time, int carId) {
        this.time = time;
        this.carId = carId;
    }

    public ElapsedTime getTime() {
        return time;
    }

    public int getCarId() {
        return carId;
    }

}
