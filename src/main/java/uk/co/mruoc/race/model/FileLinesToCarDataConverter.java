package uk.co.mruoc.race.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileLinesToCarDataConverter {

    private final SplitsToLapsConverter lapsConverter = new SplitsToLapsConverter();
    private final FileLinesToSplitsConverter splitsConverter;

    public FileLinesToCarDataConverter(DistanceProvider distanceProvider) {
        this.splitsConverter = new FileLinesToSplitsConverter(distanceProvider);
    }

    public List<CarData> toCarData(Map<Integer, List<FileLine>> carLines) {
        List<CarData> carDataList = new ArrayList<>();
        for (int carId : carLines.keySet())
            carDataList.add(toCarData(carId, carLines.get(carId)));
        return carDataList;
    }

    private CarData toCarData(int carId, List<FileLine> lines) {
        List<Split> splits = splitsConverter.toSplits(lines);
        List<Lap> laps = lapsConverter.toLaps(splits);
        return new CarData(carId, laps);
    }

}
