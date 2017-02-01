package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;

public class MaximumAverageLapSpeedPopupWindow extends PopupWindow {

    public MaximumAverageLapSpeedPopupWindow(TableModel tableModel, TableCellRenderer cellRenderer) {
        setTitle("Maximum Average Lap Speed");
        setPreferredSize(new Dimension(350, 200));
        add(new JScrollPane(new Table(tableModel, cellRenderer)));
        pack();
    }

}
