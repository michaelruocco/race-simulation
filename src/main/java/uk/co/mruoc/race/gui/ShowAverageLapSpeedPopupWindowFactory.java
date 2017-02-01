package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ShowAverageLapSpeedPopupWindowFactory extends ShowStatPopupWindowFactory {

    public ShowAverageLapSpeedPopupWindowFactory(ControlActions controlActions) {
        super(controlActions);
    }

    @Override
    protected CarStatTableModel buildTableModel() {
        return new AverageLapSpeedTableModel();
    }

    @Override
    protected JInternalFrame buildWindow(CarStatTableModel tableModel, TableCellRenderer cellRenderer) {
        return new AverageLapSpeedPopupWindow(tableModel, cellRenderer);
    }

    @Override
    protected RaceAction buildAction(JInternalFrame window) {
        return new ShowAverageLapSpeedAction(window);
    }

}
