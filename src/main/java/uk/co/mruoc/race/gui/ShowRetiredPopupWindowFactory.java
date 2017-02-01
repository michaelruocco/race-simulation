package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ShowRetiredPopupWindowFactory extends ShowStatPopupWindowFactory {

    private final TableCellRenderer cellRenderer;

    public ShowRetiredPopupWindowFactory(TableCellRenderer cellRenderer) {
        this.cellRenderer = cellRenderer;
    }

    @Override
    protected CarStatTableModel buildTableModel() {
        return new RetiredTableModel();
    }

    @Override
    protected JInternalFrame buildWindow(CarStatTableModel tableModel) {
        return new RetiredPopupWindow(tableModel, cellRenderer);
    }

    @Override
    protected RaceAction buildAction(JInternalFrame window) {
        return new ShowRetiredPopupWindowAction(window);
    }

}
