package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class ShowControlDialogAction extends RaceAction {

    private final ImageIcon smallIcon = loadIcon("/toolbarButtonGraphics/general/Preferences16.gif");
    private final ImageIcon largeIcon = loadIcon("/toolbarButtonGraphics/general/Preferences24.gif");

    private final ControlActions controlActions;

    private JFrame window;

    public ShowControlDialogAction(ControlActions controlActions) {
        setSmallIcon(smallIcon);
        setLargeIcon(largeIcon);
        setText("Control");

        this.controlActions = controlActions;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ControlDialog dialog = new ControlDialog(controlActions);
        dialog.show(window);
    }

}
