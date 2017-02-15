package uk.co.mruoc.race.gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;

public class CarImageBuilder {

    private final BufferedImage originalImage = ImageLoader.load("/uk/co/mruoc/race/gui/img/car.png");

    public Image build(Color newColor) {
        CarImageColorReplacer filter = new CarImageColorReplacer(newColor);
        ImageProducer producer = new FilteredImageSource(originalImage.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(producer);
    }

}
