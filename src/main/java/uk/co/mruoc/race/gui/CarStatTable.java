package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class CarStatTable extends JTable {

    public CarStatTable(AbstractTableModel model, Engine engine) {
        super(model);
        CarTableCellRenderer renderer = new CarTableCellRenderer();
        //engine.addLoadRaceListener(renderer);
        setDefaultRenderer(Object.class, renderer);
    }

}
