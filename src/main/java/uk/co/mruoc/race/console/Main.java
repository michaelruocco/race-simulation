package uk.co.mruoc.race.console;

import uk.co.mruoc.race.model.*;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        DistanceProvider distanceProvider = new DefaultTrackDistanceProvider();
        FileProcessor fileProcessor = new FileProcessor(distanceProvider);
        RaceData raceData = fileProcessor.process(new File("data/raceinfo.dat"));
        ConsoleReportBuilder builder = new ConsoleReportBuilder();
        String report = builder.build(raceData);
        System.out.println(report);
    }

}
