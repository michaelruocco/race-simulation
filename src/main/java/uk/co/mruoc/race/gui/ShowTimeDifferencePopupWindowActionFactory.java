package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ShowTimeDifferencePopupWindowActionFactory extends ShowStatPopupWindowActionFactory {

    @Override
    protected CarStatTableModel buildTableModel() {
        return new TimeDifferenceTableModel();
    }

    @Override
    protected JInternalFrame buildWindow(CarStatTableModel tableModel, TableCellRenderer cellRenderer) {
        return new TimeDifferencePopupWindow(tableModel, cellRenderer);
    }

    @Override
    protected ShowPopupWindowAction buildAction(JInternalFrame window) {
        return new ShowTimeDifferencePopupWindowAction(window);
    }

}
