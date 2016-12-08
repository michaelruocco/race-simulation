package uk.co.mruoc.race.model;

import java.util.Iterator;
import java.util.List;

public class RaceStats {

    private List<CarStats> carStatsList;

    public RaceStats(List<CarStats> carStatsList) {
        this.carStatsList = carStatsList;
    }

    public Iterator<CarStats> getCarStats() {
        return carStatsList.iterator();
    }

    public CarStats getCarStats(int carId) {
        for (CarStats stats : carStatsList)
            if (stats.getCarId() == carId)
                return stats;
        throw new RuntimeException("car stats for car id " + carId + " not found");
    }

}
