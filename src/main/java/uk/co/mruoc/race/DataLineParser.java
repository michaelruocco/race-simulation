package uk.co.mruoc.race;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.co.mruoc.time.ElapsedTime;
import uk.co.mruoc.time.ElapsedTimeConverter;

import static java.lang.Integer.parseInt;

public class DataLineParser {

    private static final Logger LOG = LogManager.getLogger(DataLineParser.class);

    private static final int TIME_INDEX = 0;
    private static final int CAR_ID_INDEX = 1;
    private static final int CHECKPOINT_ID_INDEX = 2;
    private static final int QUERIED_INDEX = 3;

    private final ElapsedTimeConverter elapsedTimeConverter = new ElapsedTimeConverter();
    private final DataLineValidator validator = new DataLineValidator();

    public DataLine parse(String input) {
        LOG.debug("parsing input line " + input);
        validate(input);
        String[] args = input.split(" ");
        return toLine(args);
    }

    private void validate(String input) {
        validator.validate(input);
    }

    private DataLine toLine(String[] args) {
        ElapsedTime time = toTime(args[TIME_INDEX]);
        int carId = toCarId(args[CAR_ID_INDEX]);
        int checkpointId = toCheckpointId(args[CHECKPOINT_ID_INDEX]);
        boolean queried = toQueriedFlag(args[QUERIED_INDEX]);
        return new DataLine(time, carId, checkpointId, queried);
    }

    private ElapsedTime toTime(String input) {
        return elapsedTimeConverter.toElapsedTime(input);
    }

    private int toCarId(String input) {
        return parseInt(input);
    }

    private int toCheckpointId(String input) {
        boolean retired = isRetired(input);

        if (retired)
            return -1;

        return parseInt(input);
    }

    private boolean isRetired(String input) {
        return input.equals("R");
    }

    private boolean toQueriedFlag(String input) {
        return parseInt(input) == 1;
    }

}
