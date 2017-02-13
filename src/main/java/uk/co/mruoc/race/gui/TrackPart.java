package uk.co.mruoc.race.gui;

import java.awt.geom.GeneralPath;
import java.util.List;

public interface TrackPart extends Scalable<TrackPart> {

    List<TrackPoint> getPoints();

    void moveToStart(GeneralPath path);

    void appendTo(GeneralPath path);

}
