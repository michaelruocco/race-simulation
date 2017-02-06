package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.RaceData;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Iterator;

import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

public class ImageTrackPanel extends TrackPanel {

    private final CarPainter carPainter;

    private final Image originalBackgroundImage;

    private RaceData raceData;
    private Image backgroundImage;
    private double xScale;
    private double yScale;

    public ImageTrackPanel(TrackDefinition trackDefinition) {
        setOpaque(true);
        this.carPainter = new CarPainter(trackDefinition);
        this.originalBackgroundImage = loadBackgroundImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        g2.scale(xScale, yScale);
        paintCars(g2);
    }

    @Override
    public void updateScale(double xScale, double yScale) {
        this.xScale = xScale;
        this.yScale = yScale;
        backgroundImage = originalBackgroundImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
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
