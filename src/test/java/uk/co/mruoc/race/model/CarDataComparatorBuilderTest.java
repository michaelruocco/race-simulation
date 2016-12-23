package uk.co.mruoc.race.model;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;

import static org.assertj.core.api.Assertions.assertThat;

public class CarDataComparatorBuilderTest {

    private final CarDataComparatorBuilder builder = new CarDataComparatorBuilder();

    @Test
    public void shouldReturnCarIdComparatorIfTimeIsZero() {
        ElapsedTime time = new ElapsedTime();

        assertThat(builder.build(time)).isInstanceOf(CarIdComparator.class);
    }

    @Test
    public void shouldReturnCarDistanceComparatorIfTimeIsGreaterThanZero() {
        ElapsedTime time = new ElapsedTime(1);

        assertThat(builder.build(time)).isInstanceOf(CarDistanceComparator.class);
    }

}
