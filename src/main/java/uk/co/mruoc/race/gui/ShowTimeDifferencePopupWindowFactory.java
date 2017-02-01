package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ShowTimeDifferencePopupWindowFactory extends ShowStatPopupWindowFactory {

    private final TableCellRenderer cellRenderer;

    public ShowTimeDifferencePopupWindowFactory(TableCellRenderer cellRenderer) {
        this.cellRenderer = cellRenderer;
    }

    @Override
    protected CarStatTableModel buildTableModel() {
        return new TimeDifferenceTableModel();
    }

    @Override
    protected JInternalFrame buildWindow(CarStatTableModel tableModel) {
        return new TimeDifferencePopupWindow(tableModel, cellRenderer);
    }

    @Override
    protected RaceAction buildAction(JInternalFrame window) {
        return new ShowTimeDifferencePopupWindowAction(window);
    }

}
