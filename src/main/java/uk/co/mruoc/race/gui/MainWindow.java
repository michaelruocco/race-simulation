package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.RaceData;
import uk.co.mruoc.time.ElapsedTime;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static javax.swing.JDesktopPane.OUTLINE_DRAG_MODE;

public class MainWindow extends JFrame {

    private final StatusPanel statusPanel;

    public MainWindow(ControlActions controlActions) {
        super("Race Simulation");

        JDesktopPane desktop = new JDesktopPane();
        desktop.setDragMode(OUTLINE_DRAG_MODE);

        WindowActions windowActions = new WindowActions(controlActions, desktop);

        MenuBar menuBar = new MenuBar(controlActions, windowActions);
        ToolBar toolBar = new ToolBar(controlActions, windowActions);
        this.statusPanel = new StatusPanel(controlActions);

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
