package uk.co.mruoc.race.gui;

import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;

public class LapNumberPopupWindow extends PopupWindow {

    public LapNumberPopupWindow(TableModel tableModel, TableCellRenderer cellRenderer) {
        super(new Table(tableModel, cellRenderer));
        setTitle("Lap Number");
        setPreferredSize(new Dimension(200, 200));
        pack();
    }

}
