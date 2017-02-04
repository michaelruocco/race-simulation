package uk.co.mruoc.race.gui;

import org.junit.Test;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckpointTest {

    private static final int ID = 0;
    private static final BigDecimal LOCATION = BigDecimal.valueOf(0.5);

    @Test
    public void shouldReturnId() {
        Checkpoint checkpoint = new Checkpoint(ID, LOCATION);
        assertThat(checkpoint.getId()).isEqualTo(ID);
    }

    @Test
    public void shouldReturnIndexAsLocationPercentageOfListSize() {
        Checkpoint checkpoint = new Checkpoint(ID, LOCATION);
        List<Point> points = Arrays.asList(new Point(), new Point(), new Point(), new Point(), new Point(), new Point());
        assertThat(checkpoint.calculateIndex(points)).isEqualTo(3);
    }

    @Test
    public void shouldReturnIndexLastIndexIfLocationIsOne() {
        Checkpoint checkpoint = new Checkpoint(ID, BigDecimal.ONE);
        List<Point> points = Arrays.asList(new Point(), new Point(), new Point(), new Point(), new Point(), new Point());
        assertThat(checkpoint.calculateIndex(points)).isEqualTo(points.size() - 1);
    }

}
