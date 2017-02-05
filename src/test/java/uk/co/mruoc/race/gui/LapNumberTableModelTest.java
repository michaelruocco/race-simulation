package uk.co.mruoc.race.gui;

import org.junit.Test;
import uk.co.mruoc.race.core.CarStats;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class LapNumberTableModelTest {

    private final LapNumberTableModel model = new LapNumberTableModel();

    @Test
    public void shouldReturnColumnHeadings() {
        assertThat(model.getColumnName(0)).isEqualTo("Lap");
        assertThat(model.getColumnName(1)).isEqualTo("Id");
    }

    @Test
    public void shouldFormatAverageLapSpeed() {
        CarStats stats = mock(CarStats.class);
        given(stats.getLapNumber()).willReturn(2);

        assertThat(model.getValueAt(stats, 0)).isEqualTo("2");
    }

    @Test
    public void shouldFormatCarId() {
        CarStats stats = mock(CarStats.class);
        given(stats.getCarId()).willReturn(4);

        assertThat(model.getValueAt(stats, 1)).isEqualTo("4");
    }

}
