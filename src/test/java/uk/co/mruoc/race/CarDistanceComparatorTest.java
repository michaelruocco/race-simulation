package uk.co.mruoc.race;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CarDistanceComparatorTest {

    private CarData carData1 = mock(CarData.class);
    private CarData carData2 = mock(CarData.class);

    private final CarDistanceComparator comparator = new CarDistanceComparator();

    @Test
    public void shouldReturnPositiveValueIfFirstDistancesIsLessThanSecond() {
        given(carData1.getDistance()).willReturn(0d);
        given(carData2.getDistance()).willReturn(100d);

        int result = comparator.compare(carData1, carData2);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldReturnNegativeValueIfFirstDistancesIsGreaterThanSecond() {
        given(carData1.getDistance()).willReturn(100d);
        given(carData2.getDistance()).willReturn(0d);

        int result = comparator.compare(carData1, carData2);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void shouldReturnZeroIfDistancesAndEndTimesAreEqual() {
        given(carData1.getDistance()).willReturn(0d);
        given(carData1.getEndTime()).willReturn(new ElapsedTime());

        given(carData2.getDistance()).willReturn(0d);
        given(carData2.getEndTime()).willReturn(new ElapsedTime());

        int result = comparator.compare(carData1, carData2);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldReturnNegativeValueDistancesAreEqualAndIfFirstEndTimeIsBeforeSecond() {
        given(carData1.getDistance()).willReturn(0d);
        given(carData1.getEndTime()).willReturn(new ElapsedTime());

        given(carData2.getDistance()).willReturn(0d);
        given(carData2.getEndTime()).willReturn(new ElapsedTime(1));

        int result = comparator.compare(carData1, carData2);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void shouldReturnPositiveValueIfFirstIdIsGreaterThanSecond() {
        given(carData1.getDistance()).willReturn(0d);
        given(carData1.getEndTime()).willReturn(new ElapsedTime(1));

        given(carData2.getDistance()).willReturn(0d);
        given(carData2.getEndTime()).willReturn(new ElapsedTime());

        int result = comparator.compare(carData1, carData2);

        assertThat(result).isEqualTo(1);
    }

}
