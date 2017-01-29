package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.time.ElapsedTime;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class StatusPanel extends JPanel {

    private final ClockPanel clockPanel;
    private final StatusPane statusPane;

    public StatusPanel(Controls controls) {
        this.statusPane = new StatusPane();
        this.clockPanel = new ClockPanel();

        setPreferredSize(new Dimension(220, 800));
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(controls.getStartButton());
        buttonPanel.add(controls.getStopButton());
        buttonPanel.add(controls.getResetButton());

        JPanel sliderPanel = new JPanel();
        sliderPanel.add(controls.getSpeedSlider());

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
    }

    public void updateTime(ElapsedTime time) {
        clockPanel.update(time);
    }

    public void setCssRules(CssRules cssRules) {
        statusPane.setCssRules(cssRules);
    }

    public void updateStatus(Iterator<CarStats> carStats) {
        statusPane.updateStatus(carStats);
    }

}
