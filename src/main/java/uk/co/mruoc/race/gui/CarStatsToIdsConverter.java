package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarStatsToIdsConverter {

    public List<Integer> toIds(Iterator<CarStats> carStats) {
        List<Integer> ids = new ArrayList<>();
        while(carStats.hasNext())
            ids.add(carStats.next().getCarId());
        return ids;
    }

}
