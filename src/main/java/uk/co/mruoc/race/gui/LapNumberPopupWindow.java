package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;

public class LapNumberPopupWindow extends PopupWindow {

    public LapNumberPopupWindow(TableModel tableModel, TableCellRenderer cellRenderer) {
        setTitle("Lap Number");
        setPreferredSize(new Dimension(200, 200));
        add(new JScrollPane(new Table(tableModel, cellRenderer)));
        pack();
    }

}
