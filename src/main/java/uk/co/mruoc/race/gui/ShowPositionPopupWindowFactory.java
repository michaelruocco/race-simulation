package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ShowPositionPopupWindowFactory extends ShowStatPopupWindowFactory {

    public ShowPositionPopupWindowFactory(ControlActions controlActions) {
        super(controlActions);
    }

    @Override
    protected CarStatTableModel buildTableModel() {
        return new PositionTableModel();
    }

    @Override
    protected JInternalFrame buildWindow(CarStatTableModel tableModel, TableCellRenderer cellRenderer) {
        return new PositionPopupWindow(tableModel, cellRenderer);
    }

    @Override
    protected RaceAction buildAction(JInternalFrame window) {
        return new ShowPositionPopupWindowAction(window);
    }

}
