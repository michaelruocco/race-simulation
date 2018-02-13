package uk.co.mruoc.race.gui;

import java.awt.*;

public class ImageTrackPanel extends TrackPanel {

    private static final int DEFAULT_WIDTH = 968;
    private static final int DEFAULT_HEIGHT = 567;

    private final Image backgroundImage;

    public ImageTrackPanel() {
        this(new ImageTrackDefinition());
    }

    private ImageTrackPanel(TrackDefinition trackDefinition) {
        super(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT), new ImageCarPainter(trackDefinition));
        this.backgroundImage = loadBackgroundImage();
    }

    private Image loadBackgroundImage() {
        return ImageLoader.load("/uk/co/mruoc/race/gui/img/track.png");
    }

    @Override
    protected void paintTrack(Graphics2D g) {
        g.drawImage(backgroundImage, 0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
    }

}
