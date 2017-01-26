package uk.co.mruoc.race.core;

import org.junit.Before;
import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CarDataToCarStatsConverterTest {

    private final CarData carData1 = mock(CarData.class);
    private final CarData carData2 = mock(CarData.class);
    private final CarData carData3 = mock(CarData.class);
    private final CarDistanceComparator comparator = new CarDistanceComparator();

    private final CarDataToCarStatsConverter converter = new CarDataToCarStatsConverter(comparator);

    @Before
    public void setUp() {
        given(carData1.getCarId()).willReturn(1);
        given(carData1.getSpeed()).willReturn(BigDecimal.valueOf(0.5));

        given(carData2.getCarId()).willReturn(2);
        given(carData2.getSpeed()).willReturn(BigDecimal.valueOf(0.5));

        given(carData3.getCarId()).willReturn(3);
        given(carData3.getSpeed()).willReturn(BigDecimal.valueOf(0.5));
    }

    @Test
    public void shouldSetZeroTimeDifferenceForSingleCarData() {
        List<CarData> carDataList = Collections.singletonList(carData1);

        List<CarStats> carStatsList = converter.toCarStats(carDataList);

        assertThat(carStatsList.size()).isEqualTo(1);
        assertThat(carStatsList.get(0).getCarId()).isEqualTo(1);
        assertThat(carStatsList.get(0).getTimeDifference()).isEqualTo(new ElapsedTime());
    }

    @Test
    public void shouldSetPositionsBasedOnDistanceTravelled() {
        given(carData1.getDistance()).willReturn(BigDecimal.valueOf(100));
        given(carData2.getDistance()).willReturn(BigDecimal.valueOf(200));
        given(carData3.getDistance()).willReturn(BigDecimal.valueOf(300));
        List<CarData> carDataList = Arrays.asList(carData1, carData2, carData3);

        List<CarStats> carStatsList = converter.toCarStats(carDataList);

        assertThat(carStatsList.size()).isEqualTo(3);

        CarStats carStats = carStatsList.get(0);
        assertThat(carStats.getCarId()).isEqualTo(3);
        assertThat(carStats.getPosition()).isEqualTo(1);

        carStats = carStatsList.get(1);
        assertThat(carStats.getCarId()).isEqualTo(2);
        assertThat(carStats.getPosition()).isEqualTo(2);

        carStats = carStatsList.get(2);
        assertThat(carStats.getCarId()).isEqualTo(1);
        assertThat(carStats.getPosition()).isEqualTo(3);
    }

    @Test
    public void shouldReturnZeroTimeDifferenceIfCarDataSpeedIsZero() {
        given(carData1.getDistance()).willReturn(BigDecimal.valueOf(100));
        given(carData1.getSpeed()).willReturn(BigDecimal.ZERO);

        given(carData2.getDistance()).willReturn(BigDecimal.valueOf(200));
        given(carData2.getSpeed()).willReturn(BigDecimal.ZERO);
        List<CarData> carDataList = Arrays.asList(carData1, carData2);

        List<CarStats> carStatsList = converter.toCarStats(carDataList);

        assertThat(carStatsList.size()).isEqualTo(2);

        CarStats carStats = carStatsList.get(0);
        assertThat(carStats.getCarId()).isEqualTo(2);
        assertThat(carStats.getTimeDifference()).isEqualTo(new ElapsedTime());

        carStats = carStatsList.get(1);
        assertThat(carStats.getCarId()).isEqualTo(1);
        assertThat(carStats.getTimeDifference()).isEqualTo(new ElapsedTime());
    }

    @Test
    public void shouldCalculateTimeDifference() {
        given(carData1.getDistance()).willReturn(BigDecimal.valueOf(100));
        given(carData2.getDistance()).willReturn(BigDecimal.valueOf(200));
        List<CarData> carDataList = Arrays.asList(carData1, carData2);

        List<CarStats> carStatsList = converter.toCarStats(carDataList);

        assertThat(carStatsList.size()).isEqualTo(2);

        CarStats carStats = carStatsList.get(0);
        assertThat(carStats.getCarId()).isEqualTo(2);
        assertThat(carStats.getTimeDifference()).isEqualTo(new ElapsedTime());

        carStats = carStatsList.get(1);
        assertThat(carStats.getCarId()).isEqualTo(1);
        assertThat(carStats.getTimeDifference()).isEqualTo(new ElapsedTime("00:00:00.200"));
    }

}
