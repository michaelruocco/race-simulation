package uk.co.mruoc.race.core;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class FileLoadExceptionTest {

    private final Throwable cause = mock(Throwable.class);

    @Test
    public void shouldReturnCause() {
        Throwable raceException = new FileLoadException(cause);

        assertThat(raceException.getCause()).isEqualTo(cause);
    }

}
