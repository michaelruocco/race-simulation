package uk.co.mruoc.race;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

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

        assertThat(systemOutRule.getLog()).isEqualTo("invalid option: -b\n" +
                "usage: race-simulation\n" +
                " -f,--file-path <arg>   Race data file path\n" +
                " -h,--help              Displays usage help\n" +
                " -m,--mode <arg>        Either gui or console, defaults to gui\n");
    }

    @Test
    public void shouldPrintErrorMessageAndHelpOnInvalidMode() {
        String[] args = new String[] { "-m", "test" };

        Main.main(args);

        assertThat(systemOutRule.getLog()).isEqualTo("invalid mode: test\n" +
                "usage: race-simulation\n" +
                " -f,--file-path <arg>   Race data file path\n" +
                " -h,--help              Displays usage help\n" +
                " -m,--mode <arg>        Either gui or console, defaults to gui\n");
    }

    @Test
    public void shouldPrintErrorMessageAndHelpIfFileDoesNotExist() {
        String[] args = new String[] { "-m", "console", "-f", "/invalid/path" };

        Main.main(args);

        assertThat(systemOutRule.getLog()).isEqualTo("file /invalid/path does not exist\n" +
                "usage: race-simulation\n" +
                " -f,--file-path <arg>   Race data file path\n" +
                " -h,--help              Displays usage help\n" +
                " -m,--mode <arg>        Either gui or console, defaults to gui\n");
    }

    @Test
    public void shouldPrintErrorMessageAndHelpIfFileIsInvalid() {
        String[] args = new String[] { "-m", "console", "-f", "data/invalidformat.dat" };

        Main.main(args);

        assertThat(systemOutRule.getLog()).isEqualTo("invalid data line 00:08:22.84 3 at line 196 it should contain 4 items separated by spaces\n" +
                "usage: race-simulation\n" +
                " -f,--file-path <arg>   Race data file path\n" +
                " -h,--help              Displays usage help\n" +
                " -m,--mode <arg>        Either gui or console, defaults to gui\n");
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
