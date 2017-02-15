package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.RaceData;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Iterator;

import static java.awt.Color.RED;
import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

public class ImageTrackPanel extends TrackPanel {

    private static final int DEFAULT_WIDTH = 968;
    private static final int DEFAULT_HEIGHT = 567;

    private final Image backgroundImage;
    private final TrackDefinition originalTrackDefinition;

    private RaceData raceData;
    private TrackDefinition trackDefinition;
    private ImageCarPainter carPainter;

    public ImageTrackPanel(TrackDefinition trackDefinition, ImageCarPainter imageCarPainter) {
        super(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setOpaque(true);
        this.originalTrackDefinition = trackDefinition;
        this.trackDefinition = trackDefinition;
        this.carPainter = imageCarPainter;
        this.backgroundImage = loadBackgroundImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);

        paintCars(g2);
        //paintPath(g2);
    }

    @Override
    public void scale(ScaleParams params) {
        trackDefinition = originalTrackDefinition.scale(params);
        carPainter.updateTrackDefinition(trackDefinition);
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
        return ImageLoader.load("/uk/co/mruoc/race/gui/img/track.png");
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

    private void paintPath(Graphics2D g) {
        g.setColor(RED);
        g.draw(trackDefinition.getMainPath());
        g.draw(trackDefinition.getPitPath());
    }

}
