package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.RaceData;

import javax.swing.*;
import java.awt.*;

public class ReportPopupWindow extends JInternalFrame {

    public ReportPopupWindow(RaceData raceData) {
        super("Report", false, true, false, false);
        setPreferredSize(new Dimension(400, 240));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(new JScrollPane(new StatusPane(raceData)));
        pack();
    }

}
