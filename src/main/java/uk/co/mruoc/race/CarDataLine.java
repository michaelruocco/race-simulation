package uk.co.mruoc.race;

import uk.co.mruoc.time.ElapsedTime;

public class CarDataLine {

    private final FileLine fileLine;
    private final int lapNumber;
    private final double distance;

    public CarDataLine(FileLine fileLine, int lapNumber, double distance) {
        this.fileLine = fileLine;
        this.lapNumber = lapNumber;
        this.distance = distance;
    }

    public int getCheckpointId() {
        return fileLine.getCheckpointId();
    }

    public ElapsedTime getTime() {
        return fileLine.getTime();
    }

    public int getLapNumber() {
        return lapNumber;
    }

    public double getDistance() {
        return distance;
    }

}
