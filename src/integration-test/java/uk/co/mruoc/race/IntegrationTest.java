package uk.co.mruoc.race;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.SystemOutRule;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final SystemErrRule systemErrRule = new SystemErrRule().enableLog();

    @Test
    public void shouldPrintRaceReportToStandardOut() {
        String[] args = new String[] { "-m", "console", "-f", "data/raceinfo.dat" };

        Main.main(args);

        assertThat(systemOutRule.getLog()).isEqualTo(getExpectedReportContent());
    }

    @Test
    public void shouldPrintHelp() {
        String[] args = new String[] { "-h" };

        Main.main(args);

        assertThat(systemOutRule.getLog()).isEqualTo("usage: race-simulation\n" +
                " -f,--file-path <arg>   Race data file path\n" +
                " -h,--help              Displays usage help\n" +
                " -m,--mode <arg>        Either gui or console, defaults to gui\n");
    }

    @Test
    public void shouldPrintErrorMessageAndHelpOnInvalidOption() {
        String[] args = new String[] { "-b" };

        Main.main(args);

        assertThat(systemErrRule.getLog()).isEqualTo("org.apache.commons.cli.UnrecognizedOptionException: Unrecognized option: -b\n");
        assertThat(systemOutRule.getLog()).isEqualTo("usage: race-simulation\n" +
                " -f,--file-path <arg>   Race data file path\n" +
                " -h,--help              Displays usage help\n" +
                " -m,--mode <arg>        Either gui or console, defaults to gui\n");
    }

    @Test
    public void shouldRunGui() {
        String[] args = new String[] { "-m", "gui", "-f", "data/raceinfo.dat" };

        Main.main(args);

        assertThat(systemOutRule.getLog()).isEqualTo("will run gui here using file path data/raceinfo.dat\n");
    }

    private String getExpectedReportContent() {
        try {
            URL url = IntegrationTest.class.getResource("/uk/co/mruoc/race/expectedReport");
            File file = new File(url.toURI());
            return FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}
