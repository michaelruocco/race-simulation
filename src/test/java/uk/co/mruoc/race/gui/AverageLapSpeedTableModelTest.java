package uk.co.mruoc.race.gui;

import org.junit.Test;
import uk.co.mruoc.race.core.CarStats;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class AverageLapSpeedTableModelTest {

    private final AverageLapSpeedTableModel model = new AverageLapSpeedTableModel();

    @Test
    public void shouldReturnColumnHeadings() {
        assertThat(model.getColumnName(0)).isEqualTo("Average Lap Speed");
        assertThat(model.getColumnName(1)).isEqualTo("Id");
    }

    @Test
    public void shouldFormatAverageLapSpeed() {
        CarStats stats = mock(CarStats.class);
        given(stats.getAverageLapSpeed()).willReturn(BigDecimal.valueOf(0.05));

        assertThat(model.getValueAt(stats, 0)).isEqualTo("180.00");
    }

    @Test
    public void shouldFormatCarId() {
        CarStats stats = mock(CarStats.class);
        given(stats.getCarId()).willReturn(2);

        assertThat(model.getValueAt(stats, 1)).isEqualTo("2");
    }

}
