package uk.co.mruoc.race.core;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;
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
        int carId1 = 1;
        int carId2 = 2;

        given(carStats1.getCarId()).willReturn(carId1);
        given(carStats2.getCarId()).willReturn(carId2);

        assertThat(raceStats.getCarStats(carId1)).isEqualTo(carStats1);
        assertThat(raceStats.getCarStats(carId2)).isEqualTo(carStats2);
    }

    @Test
    public void shouldThrowExceptionIfCarStatsNotFound() {
        int carId = 1;

        when(raceStats).getCarStats(carId);

        then(caughtException())
                .isInstanceOf(CarStatsNotFoundException.class)
                .hasMessage(Integer.toString(carId));
    }

}
