package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static javax.swing.JDesktopPane.OUTLINE_DRAG_MODE;

public class MainWindow extends JFrame {

    public MainWindow(ControlActions controlActions) {
        super("Race Simulation");

        JDesktopPane desktop = new JDesktopPane();
        desktop.setDragMode(OUTLINE_DRAG_MODE);

        JInternalFrame trackWindow = new TrackWindow();
        WindowActions windowActions = new WindowActions(controlActions, desktop, trackWindow);
        windowActions.showImageTrackPanelWindow();

        MenuBar menuBar = new MenuBar(controlActions, windowActions);
        ToolBar toolBar = new ToolBar(controlActions, windowActions);

        JPanel statusPanel = new StatusPanel(controlActions);

        setJMenuBar(menuBar);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(toolBar, NORTH);
        container.add(desktop, CENTER);
        container.add(statusPanel, EAST);

        pack();

        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
