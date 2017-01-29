package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class ShowControlDialogAction extends RaceAction {

    private final ImageIcon smallIcon = loadIcon("/toolbarButtonGraphics/general/Preferences16.gif");
    private final ImageIcon largeIcon = loadIcon("/toolbarButtonGraphics/general/Preferences24.gif");

    private final ControlActions controlActions;
    private final JFrame window;

    public ShowControlDialogAction(ControlActions controlActions, JFrame window) {
        setSmallIcon(smallIcon);
        setLargeIcon(largeIcon);
        setText("Control");

        this.controlActions = controlActions;
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ControlDialog dialog = new ControlDialog(controlActions, window);
        dialog.show();
    }

}
