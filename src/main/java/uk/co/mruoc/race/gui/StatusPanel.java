package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {

    private final ClockPanel clockPanel;
    private final StatusPane statusPane;

    public StatusPanel(ControlActions controlActions) {
        this.statusPane = new StatusPane(new StatusPanelHtmlBuilder());
        this.clockPanel = new ClockPanel();

        setPreferredSize(new Dimension(220, 800));
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(controlActions.getStartButton());
        buttonPanel.add(controlActions.getStopButton());
        buttonPanel.add(controlActions.getResetButton());

        JPanel sliderPanel = new JPanel();
        sliderPanel.add(controlActions.getStatusSpeedSlider());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());
        controlPanel.add(sliderPanel, BorderLayout.NORTH);
        controlPanel.add(buttonPanel, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(clockPanel, BorderLayout.CENTER);
        panel.add(controlPanel, BorderLayout.SOUTH);

        add(new JScrollPane(statusPane), BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        controlActions.addLoadRaceListener(statusPane);
        controlActions.addRaceUpdateListener(statusPane);
        controlActions.addTimeChangeListener(clockPanel);
    }

}
