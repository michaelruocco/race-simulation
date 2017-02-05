package uk.co.mruoc.race.gui;

import org.junit.Test;
import uk.co.mruoc.race.core.CarStats;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class PositionTableModelTest {

    private final CarStats stats = mock(CarStats.class);
    private final PositionTableModel model = new PositionTableModel();

    @Test
    public void shouldReturnColumnHeadings() {
        assertThat(model.getColumnName(0)).isEqualTo("Position");
        assertThat(model.getColumnName(1)).isEqualTo("Id");
    }

    @Test
    public void shouldFormatPosition() {
        given(stats.getPosition()).willReturn(1);

        assertThat(model.getValueAt(stats, 0)).isEqualTo("1");
    }

    @Test
    public void shouldFormatCarId() {
        given(stats.getCarId()).willReturn(4);

        assertThat(model.getValueAt(stats, 1)).isEqualTo("4");
    }

}
