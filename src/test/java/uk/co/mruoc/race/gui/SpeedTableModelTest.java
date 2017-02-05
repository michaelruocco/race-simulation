package uk.co.mruoc.race.gui;

import org.junit.Test;
import uk.co.mruoc.race.core.CarStats;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class SpeedTableModelTest {

    private final CarStats stats = mock(CarStats.class);
    private final SpeedTableModel model = new SpeedTableModel();

    @Test
    public void shouldReturnColumnHeadings() {
        assertThat(model.getColumnName(0)).isEqualTo("Speed");
        assertThat(model.getColumnName(1)).isEqualTo("Id");
    }

    @Test
    public void shouldFormatSpeed() {
        given(stats.getSpeed()).willReturn(BigDecimal.valueOf(0.05));

        assertThat(model.getValueAt(stats, 0)).isEqualTo("180.00");
    }

    @Test
    public void shouldFormatSpeedIfRetired() {
        given(stats.hasRetired()).willReturn(true);

        assertThat(model.getValueAt(stats, 0)).isEqualTo("-");
    }

    @Test
    public void shouldFormatCarId() {
        given(stats.getCarId()).willReturn(4);

        assertThat(model.getValueAt(stats, 1)).isEqualTo("4");
    }

}
