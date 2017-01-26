package uk.co.mruoc.race.core;

import uk.co.mruoc.time.ElapsedTime;

import java.util.Comparator;

public class CarDataComparatorBuilder {

    public Comparator<CarData> build(ElapsedTime time) {
        if (time.getTotalMillis() == 0)
            return new CarIdComparator();
        return new CarDistanceComparator();
    }

}
