package uk.co.mruoc.race.gui;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckpointTest {

    private static final double ANGLE = 0;
    private static final int ID = 0;
    private static final AngledPoint LOCATION = new AngledPoint(5, 5, ANGLE);

    @Test
    public void shouldReturnId() {
        Checkpoint checkpoint = new Checkpoint(ID, LOCATION);
        assertThat(checkpoint.getId()).isEqualTo(ID);
    }

    @Test
    public void shouldReturnIndexOfLocationInPoints() {
        Checkpoint checkpoint = new Checkpoint(ID, LOCATION);
        List<AngledPoint> points = Arrays.asList(new AngledPoint(1, 5, ANGLE),
                new AngledPoint(2, 5, ANGLE),
                new AngledPoint(3, 5, ANGLE),
                LOCATION,
                new AngledPoint(5, 5, ANGLE),
                new AngledPoint(6, 5, ANGLE));
        assertThat(checkpoint.calculateIndex(points)).isEqualTo(3);
    }

    @Test
    public void shouldReturnIndexOfClosesLocationIfExactMatchNotFound() {
        Checkpoint checkpoint = new Checkpoint(ID, LOCATION);
        List<AngledPoint> points = Arrays.asList(new AngledPoint(1, 5, ANGLE),
                new AngledPoint(2, 5, ANGLE),
                new AngledPoint(3, 5, ANGLE));
        assertThat(checkpoint.calculateIndex(points)).isEqualTo(2);
    }

}
