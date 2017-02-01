package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ShowPitStopPopupWindowFactory extends ShowStatPopupWindowFactory {

    public ShowPitStopPopupWindowFactory(ControlActions controlActions) {
        super(controlActions);
    }

    @Override
    protected CarStatTableModel buildTableModel() {
        return new PitStopTableModel();
    }

    @Override
    protected JInternalFrame buildWindow(CarStatTableModel tableModel, TableCellRenderer cellRenderer) {
        return new PitStopPopupWindow(tableModel, cellRenderer);
    }

    @Override
    protected RaceAction buildAction(JInternalFrame window) {
        return new ShowPitStopWindowAction(window);
    }

}
