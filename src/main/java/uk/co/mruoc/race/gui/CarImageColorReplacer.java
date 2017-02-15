package uk.co.mruoc.race.gui;

import java.awt.*;
import java.awt.image.RGBImageFilter;

import static java.awt.Color.BLACK;

public class CarImageColorReplacer extends RGBImageFilter {

    private final Color newColor;

    public CarImageColorReplacer(Color newColor) {
        this.newColor = newColor;
    }

    @Override
    public int filterRGB(int x, int y, int rgb) {
        if (isLightGrey(rgb)) {
            if (y == 0) {
                return BLACK.getRGB();
            }
            return newColor.getRGB();
        }
        return rgb;
    }

    private boolean isLightGrey(int rgb) {
        float hsb[] = new float[3];
        int r = (rgb >> 16) & 0xFF;
        int g = (rgb >> 8) & 0xFF;
        int b = (rgb) & 0xFF;
        Color.RGBtoHSB(r, g, b, hsb);
        float brightness = hsb[2] * 360;
        return brightness < 265 && brightness > 200;
    }

}
