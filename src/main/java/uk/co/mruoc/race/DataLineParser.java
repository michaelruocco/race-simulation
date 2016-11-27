package uk.co.mruoc.race;

import uk.co.mruoc.time.ElapsedTime;
import uk.co.mruoc.time.ElapsedTimeConverter;

public class DataLineParser {

    private final ElapsedTimeConverter elapsedTimeConverter = new ElapsedTimeConverter();

    public DataLine parse(String input) {
        String[] args = input.split(" ");
        ElapsedTime time = toTime(args[0]);
        int carId = Integer.parseInt(args[1]);
        int checkpointId = Integer.parseInt(args[2]);
        boolean queried = Integer.parseInt(args[3]) > 0;
        return new DataLine(time, carId, checkpointId, queried);
    }

    private ElapsedTime toTime(String input) {
        return elapsedTimeConverter.toElapsedTime(input);
    }

}
