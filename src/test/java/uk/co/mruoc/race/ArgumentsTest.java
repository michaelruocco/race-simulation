package uk.co.mruoc.race;

import org.junit.Test;
import uk.co.mruoc.race.Arguments.ArgumentsBuilder;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.mruoc.race.Mode.CONSOLE;
import static uk.co.mruoc.race.Mode.GUI;

public class ArgumentsTest {

    private final ArgumentsBuilder builder = new ArgumentsBuilder();

    @Test
    public void shouldRunGuiIfModeIsGui() {
        Arguments arguments = builder.setMode(GUI).build();

        assertThat(arguments.shouldRunGui()).isTrue();
    }

    @Test
    public void shouldNotRunGuiIfModeIsConsole() {
        Arguments arguments = builder.setMode(CONSOLE).build();

        assertThat(arguments.shouldRunGui()).isFalse();
    }

    @Test
    public void shouldReturnShowHelp() {
        boolean showHelp = true;

        Arguments arguments = builder.setShowHelp(showHelp).build();

        assertThat(arguments.shouldShowHelp()).isEqualTo(showHelp);
    }

    @Test
    public void shouldReturnFilePath() {
        String path = "/uk/co/mruoc/race/core/default-race.dat";
        Arguments arguments = builder.setFilePath(path).build();

        assertThat(arguments.getFilePath()).isEqualTo(path);
    }

}
