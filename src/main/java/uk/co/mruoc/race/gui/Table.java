package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class Table extends JTable {

    public Table(TableModel model, TableCellRenderer cellRenderer) {
        super(model);
        setDefaultRenderer(Object.class, cellRenderer);
    }

}
