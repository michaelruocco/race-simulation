package uk.co.mruoc.race.console;

import org.junit.Test;
import uk.co.mruoc.race.model.CarStats;
import uk.co.mruoc.time.ElapsedTime;

import java.util.Arrays;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ReportBuilderTest {

    private static final String NEW_LINE = System.lineSeparator();

    private static final String EXPECTED_REPORT =
            "-------------------------------------------------------------------------------------------------------------------------" + NEW_LINE +
            "| Position | ID | Speed | Lap Number | Time Difference | Average Lap Speed | Max Average Lap Speed | Pit Time | Pit Lap |" + NEW_LINE +
            "|----------|----|-------|------------|-----------------|-------------------|-----------------------|----------|---------|" + NEW_LINE +
            "|         0|   0|   0.00|           0|     00:00:00.000|               0.00|                   0.00|          |         |" + NEW_LINE +
            "|         0|   0|   0.00|           0|     00:00:00.000|               0.00|                   0.00|          |         |" + NEW_LINE +
            "-------------------------------------------------------------------------------------------------------------------------";

    private final ReportBuilder reportBuilder = new ReportBuilder(NEW_LINE);

    @Test
    public void shouldReturnReport() {
        CarStats stats1 = mock(CarStats.class);
        CarStats stats2 = mock(CarStats.class);

        given(stats1.getTimeDifference()).willReturn(new ElapsedTime());
        given(stats2.getTimeDifference()).willReturn(new ElapsedTime());

        Iterator<CarStats> iterator = Arrays.asList(stats1, stats2).iterator();

        String report = reportBuilder.build(iterator);

        assertThat(report).isEqualTo(EXPECTED_REPORT);
    }

}
