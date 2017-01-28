package uk.co.mruoc.race;

import org.apache.commons.cli.Option;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ModeOptionTest {

    private final Option option = new ModeOption();

    @Test
    public void shouldReturnOption() {
        assertThat(option.getOpt()).isEqualTo("m");
    }

    @Test
    public void shouldReturnName() {
        assertThat(option.getLongOpt()).isEqualTo("mode");
    }

    @Test
    public void shouldReturnDescription() {
        assertThat(option.getDescription()).isEqualTo("Either gui or console, defaults to gui");
    }

    @Test
    public void shouldHaveArgument() {
        assertThat(option.hasArg()).isTrue();
    }

}
