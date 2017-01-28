package uk.co.mruoc.race;

import org.apache.commons.cli.Option;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelpOptionTest {

    private final Option option = new HelpOption();

    @Test
    public void shouldReturnOption() {
        assertThat(option.getOpt()).isEqualTo("h");
    }

    @Test
    public void shouldReturnName() {
        assertThat(option.getLongOpt()).isEqualTo("help");
    }

    @Test
    public void shouldReturnDescription() {
        assertThat(option.getDescription()).isEqualTo("Displays usage help");
    }

    @Test
    public void shouldHaveArgument() {
        assertThat(option.hasArg()).isFalse();
    }

}
