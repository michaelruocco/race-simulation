package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.RaceData;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Collection;
import java.util.Iterator;

import static java.awt.Color.BLUE;
import static java.awt.Color.RED;
import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

public class ImageTrackPanel extends TrackPanel {

    private final Image backgroundImage;
    private final TrackDefinition originalTrackDefinition;

    private RaceData raceData;
    private TrackDefinition trackDefinition;
    private CarPainter carPainter;

    public ImageTrackPanel(TrackDefinition trackDefinition) {
        setOpaque(true);
        this.originalTrackDefinition = trackDefinition;
        this.trackDefinition = trackDefinition;
        this.carPainter = new CarPainter(trackDefinition);
        this.backgroundImage = loadBackgroundImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);

        paintCars(g2);
    }

    @Override
    public void scale(ScaleParams params) {
        trackDefinition = originalTrackDefinition.scale(params);
        carPainter = new CarPainter(trackDefinition);
    }

    @Override
    public void raceLoaded(RaceData raceData) {
        update(raceData);
    }

    @Override
    public void raceUpdated(RaceData raceData) {
        update(raceData);
    }

    private Image loadBackgroundImage() {
        try {
            return ImageIO.read(ImageTrackPanel.class.getResourceAsStream("/uk/co/mruoc/race/gui/img/track.png"));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void update(RaceData raceData) {
        this.raceData = raceData;
        repaint();
    }

    private void paintCars(Graphics2D g) {
        Iterator<CarStats> carStats = raceData.getAllCarStats();
        while (carStats.hasNext())
            carPainter.paint(carStats.next(), g);
    }

}
