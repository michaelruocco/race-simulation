package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ShowLapNumberPopupWindowActionFactory extends ShowStatPopupWindowActionFactory {

    @Override
    protected CarStatTableModel buildTableModel() {
        return new LapNumberTableModel();
    }

    @Override
    protected JInternalFrame buildWindow(CarStatTableModel tableModel, TableCellRenderer cellRenderer) {
        return new LapNumberPopupWindow(tableModel, cellRenderer);
    }

    @Override
    protected ShowPopupWindowAction buildAction(JInternalFrame window) {
        return new ShowLapNumberPopupWindowAction(window);
    }

}
