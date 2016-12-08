package uk.co.mruoc.race.model;

import java.util.Comparator;

public class CarIdComparator implements Comparator<CarData> {

    @Override
    public int compare(CarData c1, CarData c2) {
        return new Integer(c1.getCarId()).compareTo(c2.getCarId());
    }

}
