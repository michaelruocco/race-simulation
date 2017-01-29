package uk.co.mruoc.race.core;

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

    public CarStats getCarStatsByIndex(int index) {
        if (index >= carStatsList.size())
            throw new CarStatsNotFoundException("index " + Integer.toString(index));
        return carStatsList.get(index);
    }

    public CarStats getCarStatsById(int carId) {
        for (CarStats stats : carStatsList)
            if (stats.getCarId() == carId)
                return stats;
        throw new CarStatsNotFoundException("car id " + Integer.toString(carId));
    }

}
