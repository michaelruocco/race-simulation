package uk.co.mruoc.race.gui;

import javax.swing.*;

public class WindowActions {

    private final RaceAction showPositionWindow;
    private final RaceAction showSpeedWindow;
    private final RaceAction showLapNumberWindow;

    public WindowActions(Engine engine, JDesktopPane desktop) {
        showPositionWindow = new ShowPositionPopupWindowAction(engine, desktop);
        showSpeedWindow = new ShowSpeedPopupWindowAction(engine, desktop);
        showLapNumberWindow = new ShowLapNumberPopupWindowAction(engine, desktop);
    }

    public JButton getShowPositionWindowButton() {
        return new RaceButton(showPositionWindow);
    }

    public JButton getShowSpeedWindowButton() {
        return new RaceButton(showSpeedWindow);
    }

    public JButton getShowLapNumberWindowButton() {
        return new RaceButton(showLapNumberWindow);
    }

    public JMenuItem getShowPositionWindowMenuItem() {
        return new JMenuItem(showPositionWindow);
    }

    public JMenuItem getShowSpeedWindowMenuItem() {
        return new JMenuItem(showSpeedWindow);
    }

    public JMenuItem getShowLapNumberWindowMenuItem() {
        return new JMenuItem(showLapNumberWindow);
    }

}
