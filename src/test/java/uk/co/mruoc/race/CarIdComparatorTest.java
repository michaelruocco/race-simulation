package uk.co.mruoc.race;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarIdComparatorTest {

    private final DistanceProvider distanceProvider = new DefaultDistanceProvider();

    private final CarIdComparator comparator = new CarIdComparator();

    @Test
    public void shouldReturnZeroIfIdsAreEqual() {
        CarData carData1 = new CarData(distanceProvider, 0);
        CarData carData2 = new CarData(distanceProvider, 0);
        assertThat(comparator.compare(carData1, carData2)).isEqualTo(0);
    }

    @Test
    public void shouldReturnNegativeValueIfFirstIdIsLessThanSecond() {
        CarData carData1 = new CarData(distanceProvider, 0);
        CarData carData2 = new CarData(distanceProvider, 1);
        assertThat(comparator.compare(carData1, carData2)).isEqualTo(-1);
    }

    @Test
    public void shouldReturnPositiveValueIfFirstIdIsGreaterThanSecond() {
        CarData carData1 = new CarData(distanceProvider, 1);
        CarData carData2 = new CarData(distanceProvider, 0);
        assertThat(comparator.compare(carData1, carData2)).isEqualTo(1);
    }

}
