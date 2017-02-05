package uk.co.mruoc.race;

import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.UnrecognizedOptionException;
import org.junit.Test;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

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
        when(parser).parse( "-m", "consoles");

        then(caughtException())
                .isInstanceOf(InvalidModeException.class)
                .hasMessage("invalid mode: consoles")
                .hasCauseInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void shouldThrowExceptionIfOptionIsInvalid() {
        when(parser).parse("-z");

        then(caughtException())
                .isInstanceOf(InvalidOptionException.class)
                .hasMessage("invalid option: -z")
                .hasCauseInstanceOf(UnrecognizedOptionException.class);
    }
}