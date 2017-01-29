package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

public class EmptyIcon {

    private static final ImageIcon LARGE = createTransparentIcon(24, 24);
    private static final ImageIcon SMALL = createTransparentIcon(16, 16);

    public static ImageIcon getSmall() {
        return SMALL;
    }

    public static ImageIcon getLarge() {
        return LARGE;
    }

    private static BufferedImage createTransparentImage(final int width, final int height) {
        return new BufferedImage(width, height, TYPE_INT_ARGB);
    }

    private static ImageIcon createTransparentIcon(final int width, final int height) {
        return new ImageIcon(createTransparentImage(width, height));
    }

}
