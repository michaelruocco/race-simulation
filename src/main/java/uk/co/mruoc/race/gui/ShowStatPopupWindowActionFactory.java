package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public abstract class ShowStatPopupWindowActionFactory {

    private static final CarToColorConverter CAR_TO_COLOR_CONVERTER = new CarToColorConverter();

    public ShowPopupWindowAction buildAction(ControlActions controlActions) {
        CarTableCellRenderer cellRenderer = new CarTableCellRenderer(CAR_TO_COLOR_CONVERTER);
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
