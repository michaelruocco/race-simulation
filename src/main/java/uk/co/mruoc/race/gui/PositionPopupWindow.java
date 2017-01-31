package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.IdFormatter;
import uk.co.mruoc.race.core.PositionFormatter;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class PositionPopupWindow extends PopupWindow {

    public PositionPopupWindow(TableModel model, TableCellRenderer cellRenderer) {
        super(new Table(model, cellRenderer));
        setTitle("Position");
        setPreferredSize(new Dimension(200, 200));
        pack();
    }

}
