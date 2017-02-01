package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ShowSpeedPopupWindowActionFactory extends ShowStatPopupWindowActionFactory {

    @Override
    protected CarStatTableModel buildTableModel() {
        return new SpeedTableModel();
    }

    @Override
    protected JInternalFrame buildWindow(CarStatTableModel tableModel, TableCellRenderer cellRenderer) {
        return new SpeedPopupWindow(tableModel, cellRenderer);
    }

    @Override
    protected ShowPopupWindowAction buildAction(JInternalFrame window) {
        return new ShowSpeedPopupWindowAction(window);
    }

}
