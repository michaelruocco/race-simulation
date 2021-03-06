package uk.co.mruoc.race.console;

import org.junit.Test;
import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.time.ElapsedTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CarStatsToLineConverterTest {

    private final CarStatsToLineConverter converter = new CarStatsToLineConverter(new RegularColumns(""));

    @Test
    public void shouldReturnFormattedStatsLine() {
        CarStats stats = mock(CarStats.class);
        given(stats.getTimeDifference()).willReturn(new ElapsedTime());

        String line = converter.toLine(stats);

        assertThat(line).isEqualTo("|         0" +
                "|   0" +
                "|   0.00" +
                "|           0" +
                "|     00:00:00.000" +
                "|               0.00" +
                "|                      -" +
                "|             -" +
                "|        -" +
                "|");
    }

}
