package uk.co.mruoc.race.console;

import org.junit.Test;
import uk.co.mruoc.race.model.CarStats;
import uk.co.mruoc.race.model.RaceData;
import uk.co.mruoc.time.ElapsedTime;

import java.util.Arrays;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ReportsBuilderTest {

    private static final String NEW_LINE = System.lineSeparator();

    private static final String EXPECTED_REPORTS =
            NEW_LINE +
            "-----------------------------------------------------------------------------------------------------------------------------" + NEW_LINE +
            "| Position | ID | Speed | Lap Number | Time Difference | Average Lap Speed | Max Average Lap Speed |   Pit Time   | Pit Lap |" + NEW_LINE +
            "|----------|----|-------|------------|-----------------|-------------------|-----------------------|--------------|---------|" + NEW_LINE +
            "|         0|   0|   0.00|           0|     00:00:00.000|               0.00|                   0.00|             -|        -|" + NEW_LINE +
            "|         0|   0|   0.00|           0|     00:00:00.000|               0.00|                   0.00|             -|        -|" + NEW_LINE +
            "-----------------------------------------------------------------------------------------------------------------------------" + NEW_LINE +
            NEW_LINE +
            "-----------------------------------------------------------------------------------------------------------------------------" + NEW_LINE +
            "| Position | ID | Speed | Lap Number | Time Difference | Average Lap Speed | Max Average Lap Speed |   Pit Time   | Pit Lap |" + NEW_LINE +
            "|----------|----|-------|------------|-----------------|-------------------|-----------------------|--------------|---------|" + NEW_LINE +
            "|         0|   0|   0.00|           0|     00:00:00.000|               0.00|                   0.00|             -|        -|" + NEW_LINE +
            "|         0|   0|   0.00|           0|     00:00:00.000|               0.00|                   0.00|             -|        -|" + NEW_LINE +
            "-----------------------------------------------------------------------------------------------------------------------------" + NEW_LINE;

    private final ReportsBuilder reportsBuilder = new ReportsBuilder();

    @Test
    public void shouldReturnReport() {
        ElapsedTime time1 = new ElapsedTime();
        ElapsedTime time2 = new ElapsedTime();

        CarStats stats1 = mock(CarStats.class);
        CarStats stats2 = mock(CarStats.class);

        given(stats1.getTimeDifference()).willReturn(time1);
        given(stats2.getTimeDifference()).willReturn(time2);

        Iterator<CarStats> statsIterator1 = Arrays.asList(stats1, stats2).iterator();
        Iterator<CarStats> statsIterator2 = Arrays.asList(stats1, stats2).iterator();
        Iterator<ElapsedTime> timeIterator = Arrays.asList(time1, time2).iterator();

        RaceData raceData = mock(RaceData.class);
        given(raceData.getCarStats()).willReturn(statsIterator1).willReturn(statsIterator2);
        given(raceData.getQueryTimes()).willReturn(timeIterator);

        String reports = reportsBuilder.build(raceData);

        assertThat(reports).isEqualTo(EXPECTED_REPORTS);
    }

}
