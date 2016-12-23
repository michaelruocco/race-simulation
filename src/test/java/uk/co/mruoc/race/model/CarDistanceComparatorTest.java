package uk.co.mruoc.race.model;

import org.junit.Test;
import uk.co.mruoc.race.model.CarData;
import uk.co.mruoc.race.model.CarDistanceComparator;
import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CarDistanceComparatorTest {

    private final CarData carData1 = mock(CarData.class);
    private final CarData carData2 = mock(CarData.class);

    private final CarDistanceComparator comparator = new CarDistanceComparator();

    @Test
    public void shouldReturnPositiveValueIfFirstDistancesIsLessThanSecond() {
        given(carData1.getDistance()).willReturn(BigDecimal.ZERO);
        given(carData2.getDistance()).willReturn(BigDecimal.valueOf(100));

        int result = comparator.compare(carData1, carData2);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldReturnNegativeValueIfFirstDistancesIsGreaterThanSecond() {
        given(carData1.getDistance()).willReturn(BigDecimal.valueOf(100));
        given(carData2.getDistance()).willReturn(BigDecimal.ZERO);

        int result = comparator.compare(carData1, carData2);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void shouldReturnZeroIfDistancesAndEndTimesAreEqual() {
        given(carData1.getDistance()).willReturn(BigDecimal.ZERO);
        given(carData1.getEndTime()).willReturn(new ElapsedTime());

        given(carData2.getDistance()).willReturn(BigDecimal.ZERO);
        given(carData2.getEndTime()).willReturn(new ElapsedTime());

        int result = comparator.compare(carData1, carData2);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldReturnNegativeValueDistancesAreEqualAndIfFirstEndTimeIsBeforeSecond() {
        given(carData1.getDistance()).willReturn(BigDecimal.ZERO);
        given(carData1.getEndTime()).willReturn(new ElapsedTime());

        given(carData2.getDistance()).willReturn(BigDecimal.ZERO);
        given(carData2.getEndTime()).willReturn(new ElapsedTime(1));

        int result = comparator.compare(carData1, carData2);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void shouldReturnPositiveValueIfFirstIdIsGreaterThanSecond() {
        given(carData1.getDistance()).willReturn(BigDecimal.ZERO);
        given(carData1.getEndTime()).willReturn(new ElapsedTime(1));

        given(carData2.getDistance()).willReturn(BigDecimal.ZERO);
        given(carData2.getEndTime()).willReturn(new ElapsedTime());

        int result = comparator.compare(carData1, carData2);

        assertThat(result).isEqualTo(1);
    }

}
