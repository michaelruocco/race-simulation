package uk.co.mruoc.race.gui;

import org.junit.Test;
import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.time.ElapsedTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class PitStopTableModelTest {

    private final CarStats stats = mock(CarStats.class);
    private final PitStopTableModel model = new PitStopTableModel();

    @Test
    public void shouldReturnColumnHeadings() {
        assertThat(model.getColumnName(0)).isEqualTo("Id");
        assertThat(model.getColumnName(1)).isEqualTo("Time");
        assertThat(model.getColumnName(2)).isEqualTo("Lap");
    }

    @Test
    public void shouldFormatCarId() {
        given(stats.getCarId()).willReturn(4);

        assertThat(model.getValueAt(stats, 0)).isEqualTo("4");
    }

    @Test
    public void shouldFormatPitTimeIfNotPitted() {
        assertThat(model.getValueAt(stats, 1)).isEqualTo("-");
    }

    @Test
    public void shouldFormatPitLapIfNotPitted() {
        assertThat(model.getValueAt(stats, 2)).isEqualTo("-");
    }

    @Test
    public void shouldFormatPitTime() {
        given(stats.hasPitted()).willReturn(true);
        given(stats.getPitTime()).willReturn(new ElapsedTime());

        assertThat(model.getValueAt(stats, 1)).isEqualTo("00:00:00.000");
    }

    @Test
    public void shouldFormatPitLap() {
        given(stats.hasPitted()).willReturn(true);
        given(stats.getPitLapNumber()).willReturn(12);

        assertThat(model.getValueAt(stats, 2)).isEqualTo("12");
    }


}
