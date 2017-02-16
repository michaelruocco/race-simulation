package uk.co.mruoc.race;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import uk.co.mruoc.race.core.FileLoader;

public class IntegrationTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private static final String NEW_LINE = System.lineSeparator();
    private static final String USAGE = "usage: race-simulation" + NEW_LINE +
            " -f,--file-path <arg>   Race data file path" + NEW_LINE +
            " -h,--help              Displays usage help" + NEW_LINE +
            " -m,--mode <arg>        Either gui or console, defaults to gui"  + NEW_LINE;

    private final FileLoader fileLoader = new FileLoader();

    @Test
    public void shouldPrintRaceReportToStandardOut() {
        String[] args = new String[] { "-m", "console" };

        Main.main(args);

        assertThat(systemOutRule.getLog()).isEqualTo(getExpectedReportContent());
    }

    @Test
    public void shouldPrintHelp() {
        String[] args = new String[] { "-h" };

        Main.main(args);

        assertThat(systemOutRule.getLog()).isEqualTo(USAGE);
    }

    @Test
    public void shouldPrintErrorMessageAndHelpOnInvalidOption() {
        String[] args = new String[] { "-b" };

        Main.main(args);

        assertThat(systemOutRule.getLog()).isEqualTo("invalid option: -b" + NEW_LINE + USAGE);
    }

    @Test
    public void shouldPrintErrorMessageAndHelpOnInvalidMode() {
        String[] args = new String[] { "-m", "test" };

        Main.main(args);

        assertThat(systemOutRule.getLog()).isEqualTo("invalid mode: test" + NEW_LINE + USAGE);
    }

    @Test
    public void shouldPrintErrorMessageAndHelpIfFileDoesNotExist() {
        String[] args = new String[] { "-m", "console", "-f", "/invalid/path" };

        Main.main(args);

        assertThat(systemOutRule.getLog()).isEqualTo("file /invalid/path not found" + NEW_LINE + USAGE);
    }

    @Test
    public void shouldPrintErrorMessageAndHelpIfFileIsInvalid() {
        String[] args = new String[] { "-m", "console", "-f", "data/invalid-format.dat" };

        Main.main(args);

        assertThat(systemOutRule.getLog()).isEqualTo("invalid data line 00:08:22.84 3 at line 196 it should contain 4 items separated by spaces" +
                NEW_LINE + USAGE);
    }

    private String getExpectedReportContent() {
        return fileLoader.loadContent("/uk/co/mruoc/race/expectedReport");
    }

}
