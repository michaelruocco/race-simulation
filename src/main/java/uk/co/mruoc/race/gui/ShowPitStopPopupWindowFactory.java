package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ShowPitStopPopupWindowFactory extends ShowStatPopupWindowFactory {

    private final TableCellRenderer cellRenderer;

    public ShowPitStopPopupWindowFactory(TableCellRenderer cellRenderer) {
        this.cellRenderer = cellRenderer;
    }

    @Override
    protected CarStatTableModel buildTableModel() {
        return new PitStopTableModel();
    }

    @Override
    protected JInternalFrame buildWindow(CarStatTableModel tableModel) {
        return new PitStopPopupWindow(tableModel, cellRenderer);
    }

    @Override
    protected RaceAction buildAction(JInternalFrame window) {
        return new ShowPitStopWindowAction(window);
    }

}
