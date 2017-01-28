package uk.co.mruoc.race;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.mruoc.race.Mode.CONSOLE;
import static uk.co.mruoc.race.Mode.GUI;

public class ModeTest {

    @Test
    public void shouldReturnAllModes() {
        Mode[] values = Mode.values();
        assertThat(values[0]).isEqualTo(GUI);
        assertThat(values[1]).isEqualTo(CONSOLE);
    }

    @Test
    public void shouldConvertStringToMode() {
        assertThat(Mode.valueOf("GUI")).isEqualTo(GUI);
        assertThat(Mode.valueOf("CONSOLE")).isEqualTo(CONSOLE);
    }

}
