package uk.co.mruoc.race.gui;

import java.awt.*;
import java.util.*;
import java.util.List;

import static java.awt.Color.*;

public class CarToColorConverter {

    private static final Color DARK_GREEN = new Color(0, 204, 0);
    private static final Color DARK_ORANGE = new Color(255, 128, 0);
    private static final Color DARK_YELLOW = new Color(153, 153, 0);
    private static final Color PURPLE = new Color(160, 32, 240);

    private static final List<Color> COLORS = Arrays.asList(RED,
            DARK_YELLOW,
            MAGENTA,
            DARK_GREEN,
            DARK_ORANGE,
            PURPLE,
            BLUE,
            BLACK);

    public Color toColor(int carId) {
        return COLORS.get(carId);
    }

    public String toHex(int carId) {
        Color color = toColor(carId);
        return toHex(color);
    }

    public String toHex(Color color) {
        return format(toFullHex(color));
    }

    private String toFullHex(Color color) {
        return Integer.toHexString(color.getRGB());
    }

    private String format(String fullHex) {
        return "#" + fullHex.substring(2);
    }

}
