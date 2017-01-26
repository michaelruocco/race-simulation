package uk.co.mruoc.race.core;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTimeFormatException;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

public class FileLineValidatorTest {

    private final FileLineValidator validator = new FileLineValidator();

    @Test
    public void shouldReturnTrueForValidInput() {
        String validInput = "00:16:05.67 7 3 0";

        boolean result = validator.validate(validInput);

        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnTrueForValidRetiredInput() {
        String validRetiredInput = "00:16:05.67 7 R 0";

        boolean result = validator.validate(validRetiredInput);

        assertThat(result).isTrue();
    }

    @Test
    public void shouldThrowExceptionIfInputNotFormattedCorrectly() {
        String invalidLine = "invalidLine";

        when(validator).validate(invalidLine);

        then(caughtException())
                .isInstanceOf(FileLineFormatException.class)
                .hasMessage("invalid data line invalidLine it should contain 4 items separated by spaces");
    }

    @Test
    public void shouldThrowExceptionIfTimeNotFormattedCorrectly() {
        String invalidTimeLine = "16:05.67 7 3 0";

        when(validator).validate(invalidTimeLine);

        then(caughtException())
                .isInstanceOf(FileLineFormatException.class)
                .hasMessage("16:05.67")
                .hasCauseInstanceOf(ElapsedTimeFormatException.class);
    }

    @Test
    public void shouldThrowExceptionIfCarIdIsNotInteger() {
        String invalidCarIdLine = "00:16:05.67 1.1 3 0";

        when(validator).validate(invalidCarIdLine);

        then(caughtException())
                .isInstanceOf(FileLineFormatException.class)
                .hasMessage("invalid car id 1.1 it must be an integer");
    }

    @Test
    public void shouldThrowExceptionIfCheckpointIdIsNotAnIntegerOrRetired() {
        String invalidCheckpointIdLine = "00:16:05.67 7 EA 0";

        when(validator).validate(invalidCheckpointIdLine);

        then(caughtException())
                .isInstanceOf(FileLineFormatException.class)
                .hasMessage("invalid checkpoint id EA it must be an integer or R");
    }

    @Test
    public void shouldThrowExceptionIfCheckpointIdIsNotRetired() {
        String invalidCheckpointIdLine = "00:16:05.67 7 E 0";

        when(validator).validate(invalidCheckpointIdLine);

        then(caughtException())
                .isInstanceOf(FileLineFormatException.class)
                .hasMessage("invalid checkpoint id E it must be an integer or R");
    }

    @Test
    public void shouldThrowExceptionIfCheckpointIdIsNotInteger() {
        String invalidCheckpointIdLine = "00:16:05.67 7 1.1 0";

        when(validator).validate(invalidCheckpointIdLine);

        then(caughtException())
                .isInstanceOf(FileLineFormatException.class)
                .hasMessage("invalid checkpoint id 1.1 it must be an integer or R");
    }

    @Test
    public void shouldThrowExceptionIfQueriedFlagIsNotInteger() {
        String invalidCheckpointIdLine = "00:16:05.67 7 3 1.1";

        when(validator).validate(invalidCheckpointIdLine);

        then(caughtException())
                .isInstanceOf(FileLineFormatException.class)
                .hasMessage("invalid queried flag 1.1 it must be an integer");
    }

}
