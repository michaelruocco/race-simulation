package uk.co.mruoc.race.model;

import org.junit.Test;
import uk.co.mruoc.race.model.InvalidRetiredFlagException;
import uk.co.mruoc.race.model.RetiredConverter;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

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
        when(converter).toValue(INVALID_FLAG);

        then(caughtException())
                .isInstanceOf(InvalidRetiredFlagException.class)
                .hasMessage(INVALID_FLAG);
    }

}
