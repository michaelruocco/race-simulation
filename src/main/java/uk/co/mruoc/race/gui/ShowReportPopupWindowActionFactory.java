package uk.co.mruoc.race.gui;

import javax.swing.*;

public class ShowReportPopupWindowActionFactory {

    public ShowReportPopupWindowAction buildAction(ControlActions controlActions, JDesktopPane desktop) {
        ShowReportPopupWindowAction action = new ShowReportPopupWindowAction(desktop);
        controlActions.addLoadRaceListener(action);
        controlActions.addRaceUpdateListener(action);
        return action;
    }

}
