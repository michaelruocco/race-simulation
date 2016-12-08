package uk.co.mruoc.race;

import uk.co.mruoc.time.ElapsedTime;

import java.io.File;
import java.math.RoundingMode;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        SpeedConverter speedConverter = new SpeedConverter();
        DistanceProvider distanceProvider = new DefaultTrackDistanceProvider();
        FileLoader fileLoader = new FileLoader(distanceProvider);
        RaceData raceData = fileLoader.load(new File("data/raceinfo.dat"));
        Iterator<ElapsedTime> queryTimes = raceData.getQueryTimes();
        ElapsedTime time = queryTimes.next();
        raceData.setTime(time);
        System.out.println(time);
        Iterator<CarStats> carStatsIterator = raceData.getCarStats();
        while (carStatsIterator.hasNext()) {
            CarStats stats = carStatsIterator.next();
            System.out.println(stats.getPosition() + " " + stats.getCarId() + " " + stats.getLapNumber() + " " + stats.getTimeDifference() + " " + speedConverter.metersPerMilliToKmPerHour(stats.getSpeed()).setScale(2, RoundingMode.HALF_UP));
        }
    }

}
