package uk.co.mruoc.race;

import org.junit.Test;
import uk.co.mruoc.race.core.FileLoadException;
import uk.co.mruoc.race.core.RaceException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class CommandLineExceptionTest {

    private static final String MESSAGE = "Error";
    private final Throwable cause = mock(Throwable.class);

    @Test
    public void shouldReturnCause() {
        Throwable raceException = new CommandLineException(cause);

        assertThat(raceException.getCause()).isEqualTo(cause);
    }

    @Test
    public void shouldReturnMessageAndCause() {
        Throwable raceException = new RaceException(MESSAGE, cause);

        assertThat(raceException.getMessage()).isEqualTo(MESSAGE);
        assertThat(raceException.getCause()).isEqualTo(cause);
    }

}
