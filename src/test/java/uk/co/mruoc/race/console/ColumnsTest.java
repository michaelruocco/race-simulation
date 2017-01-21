package uk.co.mruoc.race.console;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ColumnsTest {

    private final Columns columns = new Columns();

    @Test
    public void separatorShouldBePipe() {
        assertThat(columns.getSeparator()).isEqualTo('|');
    }

    @Test
    public void header0ShouldBePosition() {
        assertThat(columns.getHeader(0)).isEqualTo(" Position ");
    }

    @Test
    public void header1ShouldBeId() {
        assertThat(columns.getHeader(1)).isEqualTo(" ID ");
    }

    @Test
    public void header2ShouldBeSpeed() {
        assertThat(columns.getHeader(2)).isEqualTo(" Speed ");
    }

    @Test
    public void header3ShouldBeLapNumber() {
        assertThat(columns.getHeader(3)).isEqualTo(" Lap Number ");
    }

    @Test
    public void header4ShouldBeTimeDifference() {
        assertThat(columns.getHeader(4)).isEqualTo(" Time Difference ");
    }

    @Test
    public void header5ShouldBeAverageLapSpeed() {
        assertThat(columns.getHeader(5)).isEqualTo(" Average Lap Speed ");
    }

    @Test
    public void header6ShouldBeMaxAverageLapSpeed() {
        assertThat(columns.getHeader(6)).isEqualTo(" Max Average Lap Speed ");
    }

    @Test
    public void header7ShouldBePitTime() {
        assertThat(columns.getHeader(7)).isEqualTo(" Pit Time ");
    }

    @Test
    public void header8ShouldBePitTime() {
        assertThat(columns.getHeader(8)).isEqualTo(" Pit Lap ");
    }

}
