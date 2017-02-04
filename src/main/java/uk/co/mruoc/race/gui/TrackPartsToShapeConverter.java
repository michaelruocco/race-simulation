package uk.co.mruoc.race.gui;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.List;

public class TrackPartsToShapeConverter {

    private GeneralPath toPath(List<TrackPart> parts) {
        GeneralPath path = new GeneralPath();
        for (int i = 0; i < parts.size(); i++) {
            TrackPart part = parts.get(i);
            if (i == 0) {
                part.moveToStart(path);
            }
            part.appendTo(path);
        }
        return path;
    }

    public Shape toOpenShape(List<TrackPart> parts) {
        return toPath(parts);
    }

    public Shape toClosedShape(List<TrackPart> parts) {
        GeneralPath path = toPath(parts);
        path.closePath();
        return path;
    }

}
