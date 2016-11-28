package uk.co.mruoc.race;

import java.util.ArrayList;
import java.util.List;

public class CarData {

    private final List<FileLine> lines = new ArrayList<>();
    private final int carId;

    public CarData(int carId) {
        this.carId = carId;
    }

    public int getCarId() {
        return carId;
    }

    public void add(FileLine line) {
        if (line.getCarId() != carId)
            throw new WrongCarDataException("added file line for car id " + line.getCarId() + " but should be for car id " + carId);
        lines.add(line);
    }

    public int size() {
        return lines.size();
    }

}
