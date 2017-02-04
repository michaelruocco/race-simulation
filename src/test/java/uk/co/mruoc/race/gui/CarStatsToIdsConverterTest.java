package uk.co.mruoc.race.gui;

import org.junit.Test;
import uk.co.mruoc.race.core.CarStats;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CarStatsToIdsConverterTest {

    private final CarStats stats1 = mock(CarStats.class);
    private final CarStats stats2 = mock(CarStats.class);
    private final List<CarStats> statsList = Arrays.asList(stats1, stats2);

    private final CarStatsToIdsConverter converter = new CarStatsToIdsConverter();

    @Test
    public void shouldConvertToIdsList() {
        given(stats1.getCarId()).willReturn(1);
        given(stats2.getCarId()).willReturn(2);

        List<Integer> ids = converter.toIds(statsList.iterator());

        assertThat(ids).containsExactly(1, 2);
    }

}
