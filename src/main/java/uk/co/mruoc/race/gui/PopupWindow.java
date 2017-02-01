package uk.co.mruoc.race.gui;

import javax.swing.*;

public class PopupWindow extends JInternalFrame {

    public PopupWindow(JComponent component) {
        this(component, true);
    }

    public PopupWindow(JComponent component, boolean iconifiable) {
        super("", false, true, false, iconifiable);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        add(new JScrollPane(component));
    }

}
