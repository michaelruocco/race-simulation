package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.RaceData;

import javax.swing.*;

import java.awt.event.ActionEvent;

import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class ShowReportPopupWindowAction extends RaceAction implements LoadRaceListener, RaceUpdateListener {

    private final ImageIcon smallIcon = loadIcon("/toolbarButtonGraphics/general/History16.gif");
    private final ImageIcon largeIcon = loadIcon("/toolbarButtonGraphics/general/History24.gif");

    private final JDesktopPane desktop;
    private RaceData raceData;

    public ShowReportPopupWindowAction(JDesktopPane desktop) {
        setSmallIcon(smallIcon);
        setLargeIcon(largeIcon);
        setText("Report");

        this.desktop = desktop;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JInternalFrame window = new ReportPopupWindow(raceData);
        desktop.add(window);
        window.moveToFront();
        window.setVisible(true);
    }

    public JButton getButton() {
        return new RaceButton(this);
    }

    public JMenuItem getMenuItem() {
        return new JMenuItem(this);
    }

    @Override
    public void raceUpdated(RaceData raceData) {
        this.raceData = raceData;
    }

    @Override
    public void raceLoaded(RaceData raceData) {
        this.raceData = raceData;
    }

}
