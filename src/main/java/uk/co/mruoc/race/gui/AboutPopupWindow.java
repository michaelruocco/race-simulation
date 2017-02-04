package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.*;

public class AboutPopupWindow extends PopupWindow {

    public AboutPopupWindow() {
        super(false);
        setTitle("About");
        setPreferredSize(new Dimension(400, 315));
        add(new JScrollPane(new AboutPane()));
        pack();
    }

}
