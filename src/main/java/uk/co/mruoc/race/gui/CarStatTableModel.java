package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.RaceData;
import uk.co.mruoc.time.ElapsedTime;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public abstract class CarStatTableModel extends AbstractTableModel implements TimeChangeListener, LoadRaceListener {

    private final List<String> columnNames;
    private RaceData raceData;

    public CarStatTableModel(List<String> columnNames) {
        this.columnNames = columnNames;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames.get(col);
    }

    @Override
    public int getRowCount() {
        if (raceData == null)
            return 0;
        return raceData.getCarCount();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CarStats car = getCarStats(rowIndex);
        return getValueAt(car, columnIndex);
    }

    @Override
    public void timeUpdated(ElapsedTime time) {
        fireTableDataChanged();
    }

    @Override
    public void raceLoaded(RaceData raceData) {
        this.raceData = raceData;
    }

    public abstract Object getValueAt(CarStats car, int columnIndex);

    private CarStats getCarStats(int rowIndex) {
        return raceData.getCarStatsByIndex(rowIndex);
    }

}
