package uk.co.mruoc.race.gui;

import javax.swing.*;

public class WindowActions {

    private final RaceAction showPositionWindow;

    public WindowActions(Engine engine, JDesktopPane desktop) {
        showPositionWindow = new ShowPositionPopupWindowAction(engine, desktop);
    }

    public JButton getShowPositionWindowButton() {
        return new RaceButton(showPositionWindow);
    }

}
