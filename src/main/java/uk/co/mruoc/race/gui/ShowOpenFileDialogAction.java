package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.DefaultTrack;
import uk.co.mruoc.race.core.RaceData;
import uk.co.mruoc.race.core.RaceDataLoader;
import uk.co.mruoc.race.core.Track;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static javax.swing.JFileChooser.APPROVE_OPTION;
import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class ShowOpenFileDialogAction extends RaceAction {

    private final ImageIcon smallIcon = loadIcon("/toolbarButtonGraphics/general/Open16.gif");
    private final ImageIcon largeIcon = loadIcon("/toolbarButtonGraphics/general/Open24.gif");

    private final JFileChooser fileChooser = new RaceFileChooser();
    private final JFrame window;
    private final Engine engine;

    public ShowOpenFileDialogAction(Engine engine, JFrame window) {
        setLargeIcon(largeIcon);
        setSmallIcon(smallIcon);
        setText("Open");

        this.engine = engine;
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int result = fileChooser.showOpenDialog(window);
        if (result == APPROVE_OPTION) {
            Track track = new DefaultTrack();
            RaceDataLoader loader = new RaceDataLoader(track);
            RaceData raceData = loader.loadRaceData(fileChooser.getSelectedFile());
            engine.loadRace(raceData);
        }
    }

}
