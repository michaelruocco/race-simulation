package uk.co.mruoc.race.model;

import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarDataToCarStatsConverter {

    private final Comparator<CarData> comparator;

    public CarDataToCarStatsConverter(Comparator<CarData> comparator) {
        this.comparator = comparator;
    }

    public List<CarStats> toCarStats(List<CarData> carDataList) {
        List<CarData> sortedCarDataList = sort(carDataList);
        List<CarStats> statsList = new ArrayList<>();
        CarData carInFrontData = null;
        for (int i = 0; i < sortedCarDataList.size(); i++) {
            CarData carData = sortedCarDataList.get(i);
            if (i > 0)
                carInFrontData = sortedCarDataList.get(i - 1);
            ElapsedTime timeDifference = toTimeDifference(carInFrontData, carData);
            int position = i + 1;
            statsList.add(new CarStats(position, timeDifference, carData));
        }
        return statsList;
    }

    private List<CarData> sort(List<CarData> carDataList) {
        List<CarData> sortedCarData = new ArrayList<>(carDataList);
        sortedCarData.sort(comparator);
        return sortedCarData;
    }

    private ElapsedTime toTimeDifference(CarData carData1, CarData carData2) {
        if (carData1 == null)
            return new ElapsedTime();
        if (carData1.getSpeed().equals(BigDecimal.ZERO))
            return new ElapsedTime();
        BigDecimal distanceDifference = carData1.getDistance().subtract(carData2.getDistance());
        BigDecimal timeDifferenceInMillis = distanceDifference.divide(carData1.getSpeed(), MathContext.DECIMAL32);
        return new ElapsedTime(timeDifferenceInMillis.longValue());
    }

}
