package uk.co.mruoc.race;

public class CarStats {

    private final int position;
    private final CarData carData;

    public CarStats(int position, CarData carData) {
        this.position = position;
        this.carData = carData;
    }

    public int getCarId() {
        return carData.getCarId();
    }

    public int getPosition() {
        return position;
    }

    public int getLapNumber() {
        return carData.getLapNumber();
    }

    public double getDistance() {
        return carData.getDistance();
    }

}
