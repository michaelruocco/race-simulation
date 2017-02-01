package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ShowLapNumberPopupWindowFactory extends ShowStatPopupWindowFactory {

    private final TableCellRenderer cellRenderer;

    public ShowLapNumberPopupWindowFactory(TableCellRenderer cellRenderer) {
        this.cellRenderer = cellRenderer;
    }

    @Override
    protected CarStatTableModel buildTableModel() {
        return new LapNumberTableModel();
    }

    @Override
    protected JInternalFrame buildWindow(CarStatTableModel tableModel) {
        return new LapNumberPopupWindow(tableModel, cellRenderer);
    }

    @Override
    protected RaceAction buildAction(JInternalFrame window) {
        return new ShowLapNumberPopupWindowAction(window);
    }

}
