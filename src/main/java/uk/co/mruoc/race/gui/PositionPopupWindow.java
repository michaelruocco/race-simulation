package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;

public class PositionPopupWindow extends PopupWindow {

    public PositionPopupWindow(TableModel model, TableCellRenderer cellRenderer) {
        setTitle("Position");
        setPreferredSize(new Dimension(200, 200));
        add(new JScrollPane(new Table(model, cellRenderer)));
        pack();
    }

}
