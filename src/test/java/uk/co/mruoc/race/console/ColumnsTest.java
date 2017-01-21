package uk.co.mruoc.race.console;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ColumnsTest {

    private final Columns columns = new Columns();

    @Test
    public void shouldReturnSize8() {
        assertThat(columns.size()).isEqualTo(9);
    }

    @Test
    public void separatorShouldBePipe() {
        assertThat(columns.getSeparator()).isEqualTo('|');
    }

    @Test
    public void header0ShouldBePosition() {
        int index = 0;
        String expected = " Position ";

        assertThat(columns.getHeader(index)).isEqualTo(expected);
        assertThat(columns.getWidth(index)).isEqualTo(expected.length());
    }

    @Test
    public void header1ShouldBeId() {
        int index = 1;
        String expected = " ID ";

        assertThat(columns.getHeader(index)).isEqualTo(expected);
        assertThat(columns.getWidth(index)).isEqualTo(expected.length());
    }

    @Test
    public void header2ShouldBeSpeed() {
        int index = 2;
        String expected = " Speed ";

        assertThat(columns.getHeader(index)).isEqualTo(expected);
        assertThat(columns.getWidth(index)).isEqualTo(expected.length());
    }

    @Test
    public void header3ShouldBeLapNumber() {
        int index = 3;
        String expected = " Lap Number ";

        assertThat(columns.getHeader(index)).isEqualTo(expected);
        assertThat(columns.getWidth(index)).isEqualTo(expected.length());
    }

    @Test
    public void header4ShouldBeTimeDifference() {
        int index = 4;
        String expected = " Time Difference ";

        assertThat(columns.getHeader(index)).isEqualTo(expected);
        assertThat(columns.getWidth(index)).isEqualTo(expected.length());
    }

    @Test
    public void header5ShouldBeAverageLapSpeed() {
        int index = 5;
        String expected = " Average Lap Speed ";

        assertThat(columns.getHeader(index)).isEqualTo(expected);
        assertThat(columns.getWidth(index)).isEqualTo(expected.length());
    }

    @Test
    public void header6ShouldBeMaxAverageLapSpeed() {
        int index = 6;
        String expected = " Max Average Lap Speed ";

        assertThat(columns.getHeader(index)).isEqualTo(expected);
        assertThat(columns.getWidth(index)).isEqualTo(expected.length());
    }

    @Test
    public void header7ShouldBePitTime() {
        int index = 7;
        String expected = " Pit Time ";

        assertThat(columns.getHeader(index)).isEqualTo(expected);
        assertThat(columns.getWidth(index)).isEqualTo(expected.length());
    }

    @Test
    public void header8ShouldBePitTime() {
        int index = 8;
        String expected = " Pit Lap ";

        assertThat(columns.getHeader(index)).isEqualTo(expected);
        assertThat(columns.getWidth(index)).isEqualTo(expected.length());
    }

    @Test
    public void shouldBeIterable() {
        int count = 0;
        for (String header : columns)
            count++;

        assertThat(count).isEqualTo(columns.size());
    }

}
