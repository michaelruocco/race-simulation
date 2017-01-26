package uk.co.mruoc.race.console;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RetiredColumnsTest {

    private final Columns columns = new RetiredColumns("-");

    @Test
    public void shouldReturnSize() {
        assertThat(columns.size()).isEqualTo(4);
    }

    @Test
    public void separatorShouldBePipe() {
        assertThat(columns.getColumnSeparator()).isEqualTo("|");
    }

    @Test
    public void shouldReturnHeaderWidth() {
        assertThat(columns.getWidth(0)).isEqualTo(4);
        assertThat(columns.getWidth(1)).isEqualTo(14);
        assertThat(columns.getWidth(2)).isEqualTo(13);
        assertThat(columns.getWidth(3)).isEqualTo(18);
    }

    @Test
    public void shouldReturnTotalWidth() {
        assertThat(columns.getTotalWidth()).isEqualTo(54);
    }

    @Test
    public void shouldBeIterable() {
        int count = 0;
        for (Column column : columns)
            count++;

        assertThat(count).isEqualTo(columns.size());
    }

    @Test
    public void shouldReturnHeaderRow() {
        assertThat(columns.getHeaderRow()).isEqualTo("| ID " +
                "| Retired Time " +
                "| Retired Lap " +
                "| Retired Distance " +
                "|");
    }

    @Test
    public void shouldReturnHeaderRowSeparator() {
        assertThat(columns.getHeaderSeparatorRow()).isEqualTo("|----" +
                "|--------------" +
                "|-------------" +
                "|------------------" +
                "|");
    }

}
