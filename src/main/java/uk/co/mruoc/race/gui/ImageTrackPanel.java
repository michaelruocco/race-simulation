package uk.co.mruoc.race.gui;

import java.awt.*;

import static java.awt.Color.RED;

public class ImageTrackPanel extends TrackPanel {

    private static final int DEFAULT_WIDTH = 968;
    private static final int DEFAULT_HEIGHT = 567;

    private final Image backgroundImage;
    private final TrackDefinition trackDefinition;

    public ImageTrackPanel(TrackDefinition trackDefinition) {
        super(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT), new ImageCarPainter(trackDefinition));
        this.backgroundImage = loadBackgroundImage();
        this.trackDefinition = trackDefinition;
    }

    private Image loadBackgroundImage() {
        return ImageLoader.load("/uk/co/mruoc/race/gui/img/track.png");
    }

    @Override
    protected void paintTrack(Graphics2D g) {
        g.drawImage(backgroundImage, 0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
    }

    private void paintPath(Graphics2D g) {
        g.setColor(RED);
        g.draw(trackDefinition.getMainPath());
        g.draw(trackDefinition.getPitPath());
    }

}
