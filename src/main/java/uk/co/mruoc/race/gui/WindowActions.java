package uk.co.mruoc.race.gui;

import javax.swing.*;

public class WindowActions {

    private final RaceAction showPositionWindow;
    private final RaceAction showSpeedWindow;

    public WindowActions(Engine engine, JDesktopPane desktop) {
        showPositionWindow = new ShowPositionPopupWindowAction(engine, desktop);
        showSpeedWindow = new ShowSpeedPopupWindowAction(engine, desktop);
    }

    public JButton getShowPositionWindowButton() {
        return new RaceButton(showPositionWindow);
    }

    public JButton getShowSpeedWindowButton() {
        return new RaceButton(showSpeedWindow);
    }

    public JMenuItem getShowPositionWindowMenuItem() {
        return new JMenuItem(showPositionWindow);
    }

    public JMenuItem getShowSpeedWindowMenuItem() {
        return new JMenuItem(showSpeedWindow);
    }

}
