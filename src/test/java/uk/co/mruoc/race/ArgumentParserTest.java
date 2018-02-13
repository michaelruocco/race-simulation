package uk.co.mruoc.race;

import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.UnrecognizedOptionException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class ArgumentParserTest {

    private final ArgumentParser parser = new ArgumentParser(new CommandLineOptions(), new DefaultParser());

    @Test
    public void shouldParseModeToGuiByDefault() {
        Arguments arguments = parser.parse();

        assertThat(arguments.shouldRunGui()).isTrue();
    }

    @Test
    public void shouldParseMode() {
        Arguments arguments = parser.parse( "-m", "console");

        assertThat(arguments.shouldRunGui()).isFalse();
    }

    @Test
    public void shouldParseHelp() {
        Arguments arguments = parser.parse( "-h");

        assertThat(arguments.shouldShowHelp()).isTrue();
    }

    @Test
    public void shouldReturnDefaultFilePathIfNoPathProvided() {
        Arguments arguments = parser.parse();

        assertThat(arguments.getFilePath()).isEqualTo("/uk/co/mruoc/race/default-race.dat");
    }

    @Test
    public void shouldReturnSpecifiedFilePath() {
        String path = "data/all-retired.dat";
        Arguments arguments = parser.parse("-f", path);

        assertThat(arguments.getFilePath()).isEqualTo(path);
    }

    @Test
    public void shouldThrowExceptionIfModeIsInvalid() {
        Throwable thrown = catchThrowable(() -> { parser.parse("-m", "consoles"); });

        assertThat(thrown).isInstanceOf(InvalidModeException.class)
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .hasMessage("invalid mode: consoles");
    }

    @Test
    public void shouldThrowExceptionIfOptionIsInvalid() {
        Throwable thrown = catchThrowable(() -> { parser.parse("-z"); });

        assertThat(thrown).isInstanceOf(InvalidOptionException.class)
                .hasCauseInstanceOf(UnrecognizedOptionException.class)
                .hasMessage("invalid option: -z");
    }

}
