package uk.co.mruoc.race.gui;

import javax.swing.*;

public class PopupWindow extends JInternalFrame {

    public PopupWindow() {
        this(true);
    }

    public PopupWindow(boolean iconifiable) {
        super("", false, true, false, iconifiable);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

}
