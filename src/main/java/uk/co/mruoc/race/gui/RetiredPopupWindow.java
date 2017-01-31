package uk.co.mruoc.race.gui;

import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;

public class RetiredPopupWindow extends PopupWindow {

    public RetiredPopupWindow(TableModel tableModel, TableCellRenderer cellRenderer) {
        super(new Table(tableModel, cellRenderer));
        setTitle("Retired");
        setPreferredSize(new Dimension(400, 200));
        pack();
    }

}
