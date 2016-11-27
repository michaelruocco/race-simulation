package uk.co.mruoc.race;

import uk.co.mruoc.time.ElapsedTime;
import uk.co.mruoc.time.ElapsedTimeConverter;

public class DataLineParser {

    private static final int TIME_INDEX = 0;
    private static final int CAR_ID_INDEX = 1;
    private static final int CHECKPOINT_ID_INDEX = 2;
    private static final int QUERIED_INDEX = 3;

    private final ElapsedTimeConverter elapsedTimeConverter = new ElapsedTimeConverter();

    public DataLine parse(String input) {
        String[] args = input.split(" ");
        ElapsedTime time = toTime(args[TIME_INDEX]);
        int carId = toInt(args[CAR_ID_INDEX]);
        char checkpointId = toChar(args[CHECKPOINT_ID_INDEX]);
        boolean queried = toBoolean(args[QUERIED_INDEX]);
        return new DataLine(time, carId, checkpointId, queried);
    }

    private ElapsedTime toTime(String input) {
        return elapsedTimeConverter.toElapsedTime(input);
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    private char toChar(String input) {
        return input.charAt(0);
    }

    private boolean toBoolean(String input) {
        return toInt(input) == 1;
    }

}
