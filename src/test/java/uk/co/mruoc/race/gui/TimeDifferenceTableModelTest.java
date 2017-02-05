package uk.co.mruoc.race.gui;

import org.junit.Test;
import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.time.ElapsedTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class TimeDifferenceTableModelTest {

    private final CarStats stats = mock(CarStats.class);
    private final TimeDifferenceTableModel model = new TimeDifferenceTableModel();

    @Test
    public void shouldReturnColumnHeadings() {
        assertThat(model.getColumnName(0)).isEqualTo("Time Difference");
        assertThat(model.getColumnName(1)).isEqualTo("Id");
    }

    @Test
    public void shouldFormatSpeed() {
        given(stats.getTimeDifference()).willReturn(new ElapsedTime());

        assertThat(model.getValueAt(stats, 0)).isEqualTo("00:00:00.000");
    }

    @Test
    public void shouldFormatTimeDifferenceIfLeader() {
        given(stats.getPosition()).willReturn(1);

        assertThat(model.getValueAt(stats, 0)).isEqualTo("Leader");
    }

    @Test
    public void shouldFormatTimeDifferenceIfRetired() {
        given(stats.hasRetired()).willReturn(true);

        assertThat(model.getValueAt(stats, 0)).isEqualTo("Retired");
    }

    @Test
    public void shouldFormatCarId() {
        given(stats.getCarId()).willReturn(4);

        assertThat(model.getValueAt(stats, 1)).isEqualTo("4");
    }

}
