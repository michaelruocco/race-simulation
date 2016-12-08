package uk.co.mruoc.race;

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
        for (int carId : carLines.keySet()) {
            List<Split> splits = splitsConverter.toSplits(carLines.get(carId));
            List<Lap> laps = lapsConverter.toLaps(splits);
            carDataList.add(new CarData(carId, laps));
        }
        return carDataList;
    }
}
