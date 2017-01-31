package uk.co.mruoc.race.gui;

import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;

public class SpeedPopupWindow extends PopupWindow {

    public SpeedPopupWindow(TableModel tableModel, TableCellRenderer cellRenderer) {
        super(new Table(tableModel, cellRenderer));
        setTitle("Speed");
        setPreferredSize(new Dimension(200, 200));
        pack();
    }

}
