package uk.co.mruoc.race.console;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RegularColumnsTest {

    private final Columns columns = new RegularColumns("-");

    @Test
    public void shouldReturnSize() {
        assertThat(columns.size()).isEqualTo(9);
    }

    @Test
    public void separatorShouldBePipe() {
        assertThat(columns.getColumnSeparator()).isEqualTo("|");
    }

    @Test
    public void shouldReturnHeaderWidth() {
        assertThat(columns.getWidth(0)).isEqualTo(10);
        assertThat(columns.getWidth(1)).isEqualTo(4);
        assertThat(columns.getWidth(2)).isEqualTo(7);
        assertThat(columns.getWidth(3)).isEqualTo(12);
        assertThat(columns.getWidth(4)).isEqualTo(17);
        assertThat(columns.getWidth(5)).isEqualTo(19);
        assertThat(columns.getWidth(6)).isEqualTo(23);
        assertThat(columns.getWidth(7)).isEqualTo(14);
        assertThat(columns.getWidth(8)).isEqualTo(9);
    }

    @Test
    public void shouldReturnTotalWidth() {
        assertThat(columns.getTotalWidth()).isEqualTo(125);
    }

    @Test
    public void shouldReturnHeaderRow() {
        assertThat(columns.getHeaderRow()).isEqualTo("| Position " +
                "| ID " +
                "| Speed " +
                "| Lap Number " +
                "| Time Difference " +
                "| Average Lap Speed " +
                "| Max Average Lap Speed " +
                "|   Pit Time   " +
                "| Pit Lap " +
                "|");
    }

    @Test
    public void shouldReturnHeaderRowSeparator() {
        assertThat(columns.getHeaderSeparatorRow()).isEqualTo("|----------" +
                "|----" +
                "|-------" +
                "|------------" +
                "|-----------------" +
                "|-------------------" +
                "|-----------------------" +
                "|--------------" +
                "|---------" +
                "|");
    }

}
