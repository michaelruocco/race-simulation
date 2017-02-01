package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ShowLapNumberPopupWindowFactory extends ShowStatPopupWindowFactory {

    public ShowLapNumberPopupWindowFactory(ControlActions controlActions) {
        super(controlActions);
    }

    @Override
    protected CarStatTableModel buildTableModel() {
        return new LapNumberTableModel();
    }

    @Override
    protected JInternalFrame buildWindow(CarStatTableModel tableModel, TableCellRenderer cellRenderer) {
        return new LapNumberPopupWindow(tableModel, cellRenderer);
    }

    @Override
    protected RaceAction buildAction(JInternalFrame window) {
        return new ShowLapNumberPopupWindowAction(window);
    }

}
