package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ShowAverageLapSpeedPopupWindowActionFactory extends ShowStatPopupWindowActionFactory {

    @Override
    protected CarStatTableModel buildTableModel() {
        return new AverageLapSpeedTableModel();
    }

    @Override
    protected JInternalFrame buildWindow(CarStatTableModel tableModel, TableCellRenderer cellRenderer) {
        return new AverageLapSpeedPopupWindow(tableModel, cellRenderer);
    }

    @Override
    protected ShowPopupWindowAction buildAction(JInternalFrame window) {
        return new ShowAverageLapSpeedAction(window);
    }

}
