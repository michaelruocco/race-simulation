package uk.co.mruoc.race;

import org.apache.commons.cli.Option;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FilePathOptionTest {

    private final Option option = new FilePathOption();

    @Test
    public void shouldReturnOption() {
        assertThat(option.getOpt()).isEqualTo("f");
    }

    @Test
    public void shouldReturnName() {
        assertThat(option.getLongOpt()).isEqualTo("file-path");
    }

    @Test
    public void shouldReturnDescription() {
        assertThat(option.getDescription()).isEqualTo("Race data file path");
    }

    @Test
    public void shouldHaveArgument() {
        assertThat(option.hasArg()).isTrue();
    }

}
