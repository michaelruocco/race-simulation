package uk.co.mruoc.race.gui;

import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;

public class PitStopPopupWindow extends PopupWindow {

    public PitStopPopupWindow(TableModel tableModel, TableCellRenderer cellRenderer) {
        super(new Table(tableModel, cellRenderer));
        setTitle("Pit Stop");
        setPreferredSize(new Dimension(350, 200));
        pack();
    }

}
