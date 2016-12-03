package uk.co.mruoc.race;

import java.util.Comparator;

public class CarDistanceComparator implements Comparator<CarData> {

    @Override
    public int compare(CarData c1, CarData c2) {
        if (c1.getDistance() == c2.getDistance())
            return c1.getEndTime().compareTo(c2.getEndTime());
        return new Double(c2.getDistance()).compareTo(c1.getDistance());
    }

}
