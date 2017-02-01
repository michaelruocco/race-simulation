package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ShowMaximumAverageLapSpeedPopupWindowFactory extends ShowStatPopupWindowFactory {

    public ShowMaximumAverageLapSpeedPopupWindowFactory(ControlActions controlActions) {
        super(controlActions);
    }

    @Override
    protected CarStatTableModel buildTableModel() {
        return new MaximumAverageLapSpeedTableModel();
    }

    @Override
    protected JInternalFrame buildWindow(CarStatTableModel tableModel, TableCellRenderer cellRenderer) {
        return new MaximumAverageLapSpeedPopupWindow(tableModel, cellRenderer);
    }

    @Override
    protected RaceAction buildAction(JInternalFrame window) {
        return new ShowMaximumAverageLapSpeedAction(window);
    }

}
