package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public abstract class ShowStatPopupWindowFactory {

    private final RaceAction action;
    private final JInternalFrame window;

    public ShowStatPopupWindowFactory(ControlActions controlActions) {
        CarTableCellRenderer cellRenderer = new CarTableCellRenderer();
        controlActions.addLoadRaceListener(cellRenderer);

        CarStatTableModel tableModel = buildTableModel();
        controlActions.addTimeChangeListener(tableModel);
        controlActions.addLoadRaceListener(tableModel);

        this.window = buildWindow(tableModel, cellRenderer);
        this.action = buildAction(window);
    }

    public JInternalFrame getWindow() {
        return window;
    }

    public JMenuItem getMenuItem() {
        return new JMenuItem(action);
    }

    public JButton getButton() {
        return new RaceButton(action);
    }

    protected abstract CarStatTableModel buildTableModel();

    protected abstract JInternalFrame buildWindow(CarStatTableModel tableModel, TableCellRenderer cellRenderer);

    protected abstract RaceAction buildAction(JInternalFrame window);

}
