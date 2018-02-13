package uk.co.mruoc.race.core;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class RaceStatsTest {

    private final CarStats carStats1 = mock(CarStats.class);
    private final CarStats carStats2 = mock(CarStats.class);
    private final List<CarStats> carStatsList = Arrays.asList(carStats1, carStats2);

    private final RaceStats raceStats = new RaceStats(carStatsList);

    @Test
    public void shouldReturnAllCarsIterator() {
        Iterator<CarStats> iterator = raceStats.getAllCarStats();

        assertThat(iterator.next()).isEqualTo(carStats1);
        assertThat(iterator.next()).isEqualTo(carStats2);
        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    public void shouldReturnRegularCarsIterator() {
        given(carStats2.hasRetired()).willReturn(true);

        Iterator<CarStats> iterator = raceStats.getRegularCarStats();

        assertThat(iterator.next()).isEqualTo(carStats1);
        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    public void shouldReturnRetiredCarsIterator() {
        given(carStats2.hasRetired()).willReturn(true);

        Iterator<CarStats> iterator = raceStats.getRetiredCarStats();

        assertThat(iterator.next()).isEqualTo(carStats2);
        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    public void shouldReturnCarStatsForCarId() {
        assertThat(raceStats.getCarStatsByIndex(0)).isEqualTo(carStats1);
        assertThat(raceStats.getCarStatsByIndex(1)).isEqualTo(carStats2);
    }

    @Test
    public void shouldReturnCarStatsForIndex() {
        int carId1 = 1;
        int carId2 = 2;

        given(carStats1.getCarId()).willReturn(carId1);
        given(carStats2.getCarId()).willReturn(carId2);

        assertThat(raceStats.getCarStatsById(carId1)).isEqualTo(carStats1);
        assertThat(raceStats.getCarStatsById(carId2)).isEqualTo(carStats2);
    }

    @Test
    public void shouldThrowExceptionIfCarStatsNotFoundById() {
        int carId = 1;

        Throwable thrown = catchThrowable(() -> raceStats.getCarStatsById(carId));

        assertThat(thrown).isInstanceOf(CarStatsNotFoundException.class)
                .hasMessage("car id " + Integer.toString(carId));
    }

    @Test
    public void shouldThrowExceptionIfCarStatsNotFoundByIndex() {
        int index = 2;

        Throwable thrown = catchThrowable(() -> raceStats.getCarStatsByIndex(index));

        assertThat(thrown).isInstanceOf(CarStatsNotFoundException.class)
                .hasMessage("index " + Integer.toString(index));
    }

}
