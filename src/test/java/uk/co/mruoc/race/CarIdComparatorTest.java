package uk.co.mruoc.race;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarIdComparatorTest {

    private final CarIdComparator comparator = new CarIdComparator();

    @Test
    public void shouldReturnZeroIfIdsAreEqual() {
        CarData carData1 = new CarData(new StubDistanceProvider(0), 0);
        CarData carData2 = new CarData(new StubDistanceProvider(0), 0);
        assertThat(comparator.compare(carData1, carData2)).isEqualTo(0);
    }

    @Test
    public void shouldReturnNegativeValueIfFirstIdIsLessThanSecond() {
        CarData carData1 = new CarData(new StubDistanceProvider(0), 0);
        CarData carData2 = new CarData(new StubDistanceProvider(0), 1);
        assertThat(comparator.compare(carData1, carData2)).isEqualTo(-1);
    }

    @Test
    public void shouldReturnPositiveValueIfFirstIdIsGreaterThanSecond() {
        CarData carData1 = new CarData(new StubDistanceProvider(0), 1);
        CarData carData2 = new CarData(new StubDistanceProvider(0), 0);
        assertThat(comparator.compare(carData1, carData2)).isEqualTo(1);
    }

}
