package uk.co.mruoc.race.gui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.UncheckedIOException;

public class ImageLoader {

    public static Image load(String path) {
        try {
            return ImageIO.read(ImageTrackPanel.class.getResourceAsStream(path));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
