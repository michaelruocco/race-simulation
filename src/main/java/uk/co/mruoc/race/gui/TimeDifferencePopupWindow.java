package uk.co.mruoc.race.gui;

import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;

public class TimeDifferencePopupWindow extends PopupWindow {

    public TimeDifferencePopupWindow(TableModel tableModel, TableCellRenderer cellRenderer) {
        super(new Table(tableModel, cellRenderer));
        setTitle("Time Difference");
        setPreferredSize(new Dimension(250, 200));
        pack();
    }

}
