package uk.co.mruoc.race.gui;

import javax.swing.*;

public class IconLoader {

    public static ImageIcon loadIcon(String path) {
        return new ImageIcon(IconLoader.class.getResource(path));
    }

}
