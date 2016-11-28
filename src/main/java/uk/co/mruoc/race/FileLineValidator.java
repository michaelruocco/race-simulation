package uk.co.mruoc.race;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.co.mruoc.time.ElapsedTimeFormatException;
import uk.co.mruoc.time.ElapsedTimeValidator;

public class FileLineValidator {

    private static final Logger LOG = LogManager.getLogger(FileLineValidator.class);

    private static final int NUMBER_OF_ARGUMENTS = 4;

    private static final int TIME_INDEX = 0;
    private static final int CAR_ID_INDEX = 1;
    private static final int CHECKPOINT_ID_INDEX = 2;
    private static final int QUERIED_INDEX = 3;

    private final ElapsedTimeValidator elapsedTimeValidator = new ElapsedTimeValidator();
    private final RetiredConverter retiredConverter = new RetiredConverter();

    public boolean validate(String input) {
        LOG.debug("validating input line " + input);
        validateLine(input);
        String[] args = input.split(" ");
        return validateArguments(args);
    }

    private void validateLine(String input) {
        int count = StringUtils.countMatches(input, ' ');
        if (count != NUMBER_OF_ARGUMENTS - 1)
            throw new FileLineFormatException(buildNumberOfArgumentsErrorMessage(input));
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

    private boolean validateArguments(String[] args) {
        validateTime(args[TIME_INDEX]);
        validateCarId(args[CAR_ID_INDEX]);
        validateCheckpointId(args[CHECKPOINT_ID_INDEX]);
        validateQueriedFlag(args[QUERIED_INDEX]);
        return true;
    }

    private boolean validateTime(String input) {
        try {
            return elapsedTimeValidator.validate(input);
        } catch (ElapsedTimeFormatException e) {
            throw new FileLineFormatException(input, e);
        }
    }

    private boolean validateCarId(String input) {
        if (!StringUtils.isNumeric(input))
            throw new FileLineFormatException("invalid car id " + input + " it must be an integer");
        return true;
    }

    private boolean validateCheckpointId(String input) {
        if (retiredConverter.isValid(input))
            return true;

        if (!StringUtils.isNumeric(input))
            throw new FileLineFormatException("invalid checkpoint id " + input + " it must be an integer or R");

        return true;
    }

    private boolean validateQueriedFlag(String input) {
        if (!StringUtils.isNumeric(input))
            throw new FileLineFormatException("invalid queried flag " + input + " it must be an integer");
        return true;
    }

}
