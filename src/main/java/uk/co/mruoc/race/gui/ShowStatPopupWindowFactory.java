package uk.co.mruoc.race.gui;

import javax.swing.*;

public abstract class ShowStatPopupWindowFactory {

    public RaceAction build(ControlActions controlActions, JDesktopPane desktopPane) {
        CarStatTableModel tableModel = buildTableModel();
        controlActions.addTimeChangeListener(tableModel);
        controlActions.addLoadRaceListener(tableModel);

        JInternalFrame window = buildWindow(tableModel);
        desktopPane.add(window);

        return buildAction(window);
    }

    protected abstract CarStatTableModel buildTableModel();

    protected abstract JInternalFrame buildWindow(CarStatTableModel tableModel);

    protected abstract RaceAction buildAction(JInternalFrame window);

}
