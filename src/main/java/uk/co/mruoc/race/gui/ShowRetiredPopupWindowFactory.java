package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ShowRetiredPopupWindowFactory extends ShowStatPopupWindowFactory {

    public ShowRetiredPopupWindowFactory(ControlActions controlActions) {
        super(controlActions);
    }

    @Override
    protected CarStatTableModel buildTableModel() {
        return new RetiredTableModel();
    }

    @Override
    protected JInternalFrame buildWindow(CarStatTableModel tableModel, TableCellRenderer cellRenderer) {
        return new RetiredPopupWindow(tableModel, cellRenderer);
    }

    @Override
    protected RaceAction buildAction(JInternalFrame window) {
        return new ShowRetiredPopupWindowAction(window);
    }

}
