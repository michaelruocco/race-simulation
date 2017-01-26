package uk.co.mruoc.race.model;

import java.util.Iterator;
import java.util.List;

public class RaceStats {

    private List<CarStats> carStatsList;

    public RaceStats(List<CarStats> carStatsList) {
        this.carStatsList = carStatsList;
    }

    public Iterator<CarStats> getAllCarStats() {
        return carStatsList.iterator();
    }

    public Iterator<CarStats> getRegularCarStats() {
        return carStatsList.stream().filter(s -> !s.hasRetired()).iterator();
    }

    public Iterator<CarStats> getRetiredCarStats() {
        return carStatsList.stream().filter(CarStats::hasRetired).iterator();
    }

    public CarStats getCarStats(int carId) {
        for (CarStats stats : carStatsList)
            if (stats.getCarId() == carId)
                return stats;
        throw new CarStatsNotFoundException(Integer.toString(carId));
    }

}
