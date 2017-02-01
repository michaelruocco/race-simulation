package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ShowMaximumAverageLapSpeedPopupWindowFactory extends ShowStatPopupWindowFactory {

    private final TableCellRenderer cellRenderer;

    public ShowMaximumAverageLapSpeedPopupWindowFactory(TableCellRenderer cellRenderer) {
        this.cellRenderer = cellRenderer;
    }

    @Override
    protected CarStatTableModel buildTableModel() {
        return new MaximumAverageLapSpeedTableModel();
    }

    @Override
    protected JInternalFrame buildWindow(CarStatTableModel tableModel) {
        return new MaximumAverageLapSpeedPopupWindow(tableModel, cellRenderer);
    }

    @Override
    protected RaceAction buildAction(JInternalFrame window) {
        return new ShowMaximumAverageLapSpeedAction(window);
    }

}
