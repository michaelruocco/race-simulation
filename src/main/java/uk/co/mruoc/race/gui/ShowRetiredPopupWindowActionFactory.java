package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ShowRetiredPopupWindowActionFactory extends ShowStatPopupWindowActionFactory {

    @Override
    protected CarStatTableModel buildTableModel() {
        return new RetiredTableModel();
    }

    @Override
    protected JInternalFrame buildWindow(CarStatTableModel tableModel, TableCellRenderer cellRenderer) {
        return new RetiredPopupWindow(tableModel, cellRenderer);
    }

    @Override
    protected ShowPopupWindowAction buildAction(JInternalFrame window) {
        return new ShowRetiredPopupWindowAction(window);
    }

}
