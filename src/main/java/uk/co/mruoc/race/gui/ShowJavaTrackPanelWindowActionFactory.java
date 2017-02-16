package uk.co.mruoc.race.gui;

import javax.swing.*;

public class ShowJavaTrackPanelWindowActionFactory extends ShowTrackPanelWindowActionFactory {

    public ShowJavaTrackPanelWindowActionFactory(JInternalFrame window) {
        super(window, new JavaTrackPanel());
    }

    @Override
    protected ShowTrackPanelWindowAction buildAction(JInternalFrame window, JPanel panel) {
        return new ShowJavaTrackPanelWindowAction(window, panel);
    }

}
