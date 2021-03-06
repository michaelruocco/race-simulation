package uk.co.mruoc.race.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.co.mruoc.time.ElapsedTime;
import uk.co.mruoc.time.ElapsedTimeConverter;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static uk.co.mruoc.race.core.FileLine.*;

public class FileLineParser {

    private static final Logger LOG = LogManager.getLogger(FileLineParser.class);

    private static final int TIME_INDEX = 0;
    private static final int CAR_ID_INDEX = 1;
    private static final int CHECKPOINT_ID_INDEX = 2;
    private static final int QUERIED_INDEX = 3;

    private final ElapsedTimeConverter elapsedTimeConverter = new ElapsedTimeConverter();
    private final FileLineValidator validator = new FileLineValidator();
    private final RetiredConverter retiredConverter = new RetiredConverter();

    public List<FileLine> parse(List<Line> inputs) {
        List<FileLine> lines = new ArrayList<>();
        inputs.forEach(i -> lines.add(parse(i)));
        return lines;
    }

    public FileLine parse(Line input) {
        LOG.debug("parsing input line " + input.debug());
        validate(input);
        String[] args = input.splitValue();
        return toLine(args);
    }

    private void validate(Line input) {
        validator.validate(input);
    }

    private FileLine toLine(String[] args) {
        ElapsedTime time = toTime(args[TIME_INDEX]);
        int carId = toCarId(args[CAR_ID_INDEX]);
        int checkpointId = toCheckpointId(args[CHECKPOINT_ID_INDEX]);
        boolean queried = toQueriedFlag(args[QUERIED_INDEX]);
        return new FileLineBuilder()
                .setTime(time)
                .setCarId(carId)
                .setCheckpointId(checkpointId)
                .setQueried(queried)
                .build();
    }

    private ElapsedTime toTime(String input) {
        return elapsedTimeConverter.toElapsedTime(input);
    }

    private int toCarId(String input) {
        return parseInt(input);
    }

    private int toCheckpointId(String input) {
        if (retiredConverter.isValid(input))
            return retiredConverter.toValue(input);
        return parseInt(input);
    }

    private boolean toQueriedFlag(String input) {
        return parseInt(input) == 1;
    }

}
