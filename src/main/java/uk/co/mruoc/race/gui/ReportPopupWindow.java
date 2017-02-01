package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.RaceData;
import uk.co.mruoc.time.ElapsedTime;

import javax.swing.*;
import java.awt.*;

public class ReportPopupWindow extends JInternalFrame {

    public ReportPopupWindow(RaceData raceData) {
        super(buildTitle(raceData), false, true, false, false);
        setPreferredSize(new Dimension(1000, 290));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(new JScrollPane(new StatusPane(new ReportWindowHtmlBuilder(), raceData)));
        pack();
    }

    private static String buildTitle(RaceData raceData) {
        ElapsedTime time = raceData.getTime();
        return "Report at: " + time.toString();
    }

}
