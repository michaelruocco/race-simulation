package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.RaceData;
import uk.co.mruoc.time.ElapsedTime;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static javax.swing.JDesktopPane.OUTLINE_DRAG_MODE;

public class MainWindow extends JFrame implements TimeChangeListener, LoadRaceListener, RaceUpdateListener {

    private final CarStatsToCssRulesConverter carStatsToCssRulesConverter = new CarStatsToCssRulesConverter();
    private final StatusPanel statusPanel;

    public MainWindow(Engine engine) {
        super("Race Simulation");

        JDesktopPane desktop = new JDesktopPane();

        ControlActions controlActions = new ControlActions(engine, this);
        WindowActions windowActions = new WindowActions(engine, desktop);

        MenuBar menuBar = new MenuBar(controlActions, windowActions);
        ToolBar toolBar = new ToolBar(controlActions, windowActions);

        setJMenuBar(menuBar);

        desktop.setDragMode(OUTLINE_DRAG_MODE);

        this.statusPanel = new StatusPanel(controlActions);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(toolBar, NORTH);
        container.add(desktop, CENTER);
        container.add(statusPanel, EAST);

        pack();

        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void timeUpdated(ElapsedTime time) {
        statusPanel.updateTime(time);
    }

    @Override
    public void raceLoaded(RaceData raceData) {
        CssRules cssRules = carStatsToCssRulesConverter.toCssRules(raceData.getAllCarStats());
        statusPanel.setCssRules(cssRules);
    }

    @Override
    public void raceUpdated(RaceData raceData) {
        statusPanel.updateStatus(raceData.getAllCarStats());
    }

}
