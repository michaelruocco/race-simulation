package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public abstract class ShowStatPopupWindowActionFactory {

    public ShowPopupWindowAction buildAction(ControlActions controlActions) {
        CarTableCellRenderer cellRenderer = new CarTableCellRenderer();
        controlActions.addLoadRaceListener(cellRenderer);

        CarStatTableModel tableModel = buildTableModel();
        controlActions.addTimeChangeListener(tableModel);
        controlActions.addLoadRaceListener(tableModel);

        JInternalFrame window = buildWindow(tableModel, cellRenderer);
        return buildAction(window);
    }

    protected abstract CarStatTableModel buildTableModel();

    protected abstract JInternalFrame buildWindow(CarStatTableModel tableModel, TableCellRenderer cellRenderer);

    protected abstract ShowPopupWindowAction buildAction(JInternalFrame window);

}
