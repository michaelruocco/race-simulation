package uk.co.mruoc.race;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.co.mruoc.time.ElapsedTime;
import uk.co.mruoc.time.ElapsedTimeConverter;
import uk.co.mruoc.time.ElapsedTimeFormatException;

import static java.lang.Integer.parseInt;
import static org.apache.commons.lang3.math.NumberUtils.toInt;

public class DataLineParser {

    private static final Logger LOG = LogManager.getLogger(DataLineParser.class);

    private static final int NUMBER_OF_ARGUMENTS = 4;

    private static final int TIME_INDEX = 0;
    private static final int CAR_ID_INDEX = 1;
    private static final int CHECKPOINT_ID_INDEX = 2;
    private static final int QUERIED_INDEX = 3;

    private final ElapsedTimeConverter elapsedTimeConverter = new ElapsedTimeConverter();

    public DataLine parse(String input) {
        LOG.debug("parsing input line " + input);
        validate(input);
        String[] args = input.split(" ");
        return toLine(args);
    }

    private void validate(String input) {
        int count = StringUtils.countMatches(input, ' ');
        if (count != NUMBER_OF_ARGUMENTS - 1)
            throw new DataLineFormatException(buildNumberOfArgumentsErrorMessage(input));
    }

    private String buildNumberOfArgumentsErrorMessage(String input) {
        StringBuilder message = new StringBuilder();
        message.append("invalid data line ");
        message.append(input);
        message.append(" it should contain ");
        message.append(NUMBER_OF_ARGUMENTS);
        message.append(" items separated by spaces");
        return message.toString();
    }

    private DataLine toLine(String[] args) {
        ElapsedTime time = toTime(args[TIME_INDEX]);
        int carId = toCarId(args[CAR_ID_INDEX]);
        int checkpointId = toCheckpointId(args[CHECKPOINT_ID_INDEX]);
        boolean queried = toQueriedFlag(args[QUERIED_INDEX]);
        return new DataLine(time, carId, checkpointId, queried);
    }

    private ElapsedTime toTime(String input) {
        try {
            return elapsedTimeConverter.toElapsedTime(input);
        } catch (ElapsedTimeFormatException e) {
            throw new DataLineFormatException(input, e);
        }
    }

    private int toCarId(String input) {
        try {
            return parseInt(input);
        } catch (NumberFormatException e) {
            throw new DataLineFormatException("invalid car id " + input + " it must be an integer", e);
        }
    }

    private int toCheckpointId(String input) {
        boolean retired = isRetired(input);

        if (retired)
            return -1;

        if (!StringUtils.isNumeric(input))
            throw new DataLineFormatException("invalid checkpoint id " + input + " it must be an integer or R");

        try {
            return parseInt(input);
        } catch (NumberFormatException e) {
            throw new DataLineFormatException("invalid checkpoint id " + input + " it must be an integer or R", e);
        }
    }

    private boolean isRetired(String input) {
        return input.equals("R");
    }

    private boolean toQueriedFlag(String input) {
        try {
            return parseInt(input) == 1;
        } catch (NumberFormatException e) {
            throw new DataLineFormatException("invalid queried flag " + input + " it must be an integer", e);
        }
    }

}
