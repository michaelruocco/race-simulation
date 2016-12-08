package uk.co.mruoc.race.model;

import java.util.Comparator;

public class CarDistanceComparator implements Comparator<CarData> {

    @Override
    public int compare(CarData c1, CarData c2) {
        if (c1.getDistance().equals(c2.getDistance()))
            return c1.getEndTime().compareTo(c2.getEndTime());
        return c2.getDistance().compareTo(c1.getDistance());
    }

}
