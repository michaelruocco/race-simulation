package uk.co.mruoc.race.gui;

import javax.swing.*;

public class ShowImageTrackPanelWindowActionFactory extends ShowTrackPanelWindowActionFactory {

    public ShowImageTrackPanelWindowActionFactory(JInternalFrame window) {
        super(window, new ImageTrackPanel());
    }

    @Override
    protected ShowTrackPanelWindowAction buildAction(JInternalFrame window, JPanel panel) {
        return new ShowImageTrackPanelWindowAction(window, panel);
    }

}
