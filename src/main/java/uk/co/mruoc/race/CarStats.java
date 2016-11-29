package uk.co.mruoc.race;

public class CarStats {

    private final int lapNumber;
    private final double distance;

    public CarStats(int lapNumber, double distance) {
        this.lapNumber = lapNumber;
        this.distance = distance;
    }

    public int getLapNumber() {
        return lapNumber;
    }

    public double getDistance() {
        return distance;
    }

}
