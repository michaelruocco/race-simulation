package uk.co.mruoc.race.core;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class RetiredConverterTest {

    private static final String INVALID_FLAG = "";
    private static final String VALID_FLAG = "R";
    private static final int RETIRED_VALUE = -1;

    private final RetiredConverter converter = new RetiredConverter();

    @Test
    public void shouldValidateFlag() {
        assertThat(converter.isValid(INVALID_FLAG)).isFalse();
        assertThat(converter.isValid(VALID_FLAG)).isTrue();
    }

    @Test
    public void shouldConvertToValueIfValid() {
        assertThat(converter.toValue(VALID_FLAG)).isEqualTo(RETIRED_VALUE);
    }

    @Test
    public void shouldConvertRetiredValue() {
        assertThat(converter.isRetired(RETIRED_VALUE)).isTrue();
        assertThat(converter.isRetired(0)).isFalse();
        assertThat(converter.isRetired(-2)).isFalse();
    }

    @Test
    public void shouldThrowExceptionIfNotValue() {
        Throwable thrown = catchThrowable(() -> converter.toValue(INVALID_FLAG));

        assertThat(thrown).isInstanceOf(InvalidRetiredFlagException.class)
                .hasMessage(INVALID_FLAG);
    }

}
