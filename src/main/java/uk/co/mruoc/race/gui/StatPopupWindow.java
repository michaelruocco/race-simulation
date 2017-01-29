package uk.co.mruoc.race.gui;

import javax.swing.*;

public class StatPopupWindow extends JInternalFrame {

    public StatPopupWindow(JTable table) {
        super("", false, true, false, true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        add(new JScrollPane(table));
    }

}
