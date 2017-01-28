package uk.co.mruoc.race.core;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class RaceExeptionTest {

    private static final String MESSAGE = "Error";
    private final Throwable cause = mock(Throwable.class);

    @Test
    public void shouldReturnMessage() {
        Throwable raceException = new RaceException(MESSAGE);

        assertThat(raceException.getMessage()).isEqualTo(MESSAGE);
    }

    @Test
    public void shouldReturnCause() {
        Throwable raceException = new RaceException(cause);

        assertThat(raceException.getCause()).isEqualTo(cause);
    }

    @Test
    public void shouldReturnMessageAndCause() {
        Throwable raceException = new RaceException(MESSAGE, cause);

        assertThat(raceException.getMessage()).isEqualTo(MESSAGE);
        assertThat(raceException.getCause()).isEqualTo(cause);
    }

}
