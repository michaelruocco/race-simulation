package uk.co.mruoc.race.gui;

import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckpointTest {

    private static final int ID = 0;
    private static final Point LOCATION = new Point(5, 5);

    @Test
    public void shouldReturnId() {
        Checkpoint checkpoint = new Checkpoint(ID, LOCATION);
        assertThat(checkpoint.getId()).isEqualTo(ID);
    }

    @Test
    public void shouldReturnIndexOfLocationInPoints() {
        Checkpoint checkpoint = new Checkpoint(ID, LOCATION);
        List<Point> points = Arrays.asList(new Point(1, 5),
                new Point(2, 5),
                new Point(3, 5),
                LOCATION,
                new Point(5, 5),
                new Point(6, 5));
        assertThat(checkpoint.calculateIndex(points)).isEqualTo(3);
    }

    @Test
    public void shouldReturnIndexOfClosesLocationIfExactMatchNotFound() {
        Checkpoint checkpoint = new Checkpoint(ID, LOCATION);
        List<Point> points = Arrays.asList(new Point(1, 5),
                new Point(2, 5),
                new Point(3, 5));
        assertThat(checkpoint.calculateIndex(points)).isEqualTo(2);
    }

}
