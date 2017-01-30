package uk.co.mruoc.race.gui;

import javax.swing.*;

public class PopupWindow extends JInternalFrame {

    public PopupWindow(JComponent component) {
        super("", false, true, false, true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        add(new JScrollPane(component));
    }

}
