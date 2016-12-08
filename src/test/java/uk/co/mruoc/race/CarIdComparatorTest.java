package uk.co.mruoc.race;

import org.junit.Test;
import uk.co.mruoc.race.model.CarData;
import uk.co.mruoc.race.model.CarIdComparator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CarIdComparatorTest {

    private final CarData carData1 = mock(CarData.class);
    private final CarData carData2 = mock(CarData.class);

    private final CarIdComparator comparator = new CarIdComparator();

    @Test
    public void shouldReturnZeroIfIdsAreEqual() {
        given(carData1.getCarId()).willReturn(0);
        given(carData2.getCarId()).willReturn(0);

        int result = comparator.compare(carData1, carData2);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldReturnNegativeValueIfFirstIdIsLessThanSecond() {
        given(carData1.getCarId()).willReturn(0);
        given(carData2.getCarId()).willReturn(1);

        int result = comparator.compare(carData1, carData2);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void shouldReturnPositiveValueIfFirstIdIsGreaterThanSecond() {
        given(carData1.getCarId()).willReturn(1);
        given(carData2.getCarId()).willReturn(0);

        int result = comparator.compare(carData1, carData2);

        assertThat(result).isEqualTo(1);
    }

}
