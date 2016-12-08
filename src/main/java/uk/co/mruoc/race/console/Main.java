package uk.co.mruoc.race.console;

import uk.co.mruoc.race.model.*;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        SpeedConverter speedConverter = new SpeedConverter();
        DistanceProvider distanceProvider = new DefaultTrackDistanceProvider();
        FileLoader fileLoader = new FileLoader(distanceProvider);
        RaceData raceData = fileLoader.load(new File("data/raceinfo.dat"));
        ConsoleReportBuilder builder = new ConsoleReportBuilder();
        String report = builder.build(raceData);
        System.out.println(report);
    }

}
