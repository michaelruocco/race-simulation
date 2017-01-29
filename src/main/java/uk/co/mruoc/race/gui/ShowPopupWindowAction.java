package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ShowPopupWindowAction extends RaceAction {

    private final JInternalFrame window;

    public ShowPopupWindowAction(JDesktopPane desktop, JInternalFrame window) {
        this.window = window;
        desktop.add(window);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.moveToFront();

        if (window.isVisible())
            return;

        window.setVisible(true);
    }

}
