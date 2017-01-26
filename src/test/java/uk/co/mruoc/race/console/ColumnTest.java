package uk.co.mruoc.race.console;

import org.junit.Test;
import uk.co.mruoc.race.model.CarStatFormatter;
import uk.co.mruoc.race.model.CarStats;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class ColumnTest {

    private static final String HEADER = "Header";
    private static final String VALUE = "Value";

    private final Column column = new Column(HEADER, new FakeCarStatFormatter());

    @Test
    public void shouldReturnHeader() {
        assertThat(column.getHeader()).isEqualTo(HEADER);
    }

    @Test
    public void shouldReturnWidth() {
        assertThat(column.getWidth()).isEqualTo(HEADER.length());
    }

    @Test
    public void shouldFormatValueAndLeftPadToColumnWidth() {
        CarStats stats = mock(CarStats.class);
        assertThat(column.formatValue(stats)).isEqualTo(" " + VALUE);
    }

    private static final class FakeCarStatFormatter implements CarStatFormatter {

        @Override
        public String format(CarStats stats) {
            return VALUE;
        }

    }

}
