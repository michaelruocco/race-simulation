package uk.co.mruoc.race;

import uk.co.mruoc.race.console.ReportsBuilder;
import uk.co.mruoc.race.model.*;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        Track track = new DefaultTrack();
        FileLinesToSplitsConverter splitsConverter = new FileLinesToSplitsConverter(track);
        FileLinesToCarDataConverter carDataConverter = new FileLinesToCarDataConverter(splitsConverter);
        FileProcessor fileProcessor = new FileProcessor(carDataConverter);
        RaceData raceData = fileProcessor.process(new File("data/raceinfo.dat"));
        ReportsBuilder builder = new ReportsBuilder();
        String report = builder.build(raceData);
        System.out.println(report);
    }

}
