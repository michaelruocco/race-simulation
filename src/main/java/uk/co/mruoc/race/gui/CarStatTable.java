package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class CarStatTable extends JTable {

    public CarStatTable(AbstractTableModel model, TableCellRenderer cellRenderer) {
        super(model);
        setDefaultRenderer(Object.class, cellRenderer);
    }

}
