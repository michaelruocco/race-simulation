package uk.co.mruoc.race.gui;

import org.junit.Test;
import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class RetiredTableModelTest {

    private final CarStats stats = mock(CarStats.class);
    private final RetiredTableModel model = new RetiredTableModel();

    @Test
    public void shouldReturnColumnHeadings() {
        assertThat(model.getColumnName(0)).isEqualTo("Id");
        assertThat(model.getColumnName(1)).isEqualTo("Time");
        assertThat(model.getColumnName(2)).isEqualTo("Lap");
        assertThat(model.getColumnName(3)).isEqualTo("Distance");
    }

    @Test
    public void shouldFormatCarId() {
        given(stats.getCarId()).willReturn(4);

        assertThat(model.getValueAt(stats, 0)).isEqualTo("4");
    }

    @Test
    public void shouldFormatRetiredTimeIfNotRetired() {
        assertThat(model.getValueAt(stats, 1)).isEqualTo("-");
    }

    @Test
    public void shouldFormatRetiredLapIfNotRetired() {
        assertThat(model.getValueAt(stats, 2)).isEqualTo("-");
    }

    @Test
    public void shouldFormatRetiredDistanceIfNotRetired() {
        assertThat(model.getValueAt(stats, 3)).isEqualTo("-");
    }

    @Test
    public void shouldFormatRetiredTime() {
        given(stats.hasRetired()).willReturn(true);
        given(stats.getRetiredTime()).willReturn(new ElapsedTime());

        assertThat(model.getValueAt(stats, 1)).isEqualTo("00:00:00.000");
    }

    @Test
    public void shouldFormatRetiredLap() {
        given(stats.hasRetired()).willReturn(true);
        given(stats.getLapNumber()).willReturn(12);

        assertThat(model.getValueAt(stats, 2)).isEqualTo("12");
    }

    @Test
    public void shouldFormatRetiredDistance() {
        given(stats.hasRetired()).willReturn(true);
        given(stats.getDistance()).willReturn(BigDecimal.valueOf(123.123));

        assertThat(model.getValueAt(stats, 3)).isEqualTo("123.12");
    }

}
