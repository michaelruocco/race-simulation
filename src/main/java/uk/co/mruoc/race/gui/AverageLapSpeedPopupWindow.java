package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;

public class AverageLapSpeedPopupWindow extends PopupWindow {

    public AverageLapSpeedPopupWindow(TableModel model, TableCellRenderer cellRenderer) {
        setTitle("Average Lap Speed");
        setPreferredSize(new Dimension(250, 200));
        add(new JScrollPane(new Table(model, cellRenderer)));
        pack();
    }



}
