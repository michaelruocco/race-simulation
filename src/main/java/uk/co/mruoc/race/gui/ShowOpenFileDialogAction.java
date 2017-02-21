package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;

import static javax.swing.JFileChooser.APPROVE_OPTION;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static uk.co.mruoc.race.gui.IconLoader.loadIcon;

public class ShowOpenFileDialogAction extends RaceAction {

    private static final String ERROR_MESSAGE_TITLE = "Race File Load Error";

    private final ImageIcon smallIcon = loadIcon("/toolbarButtonGraphics/general/Open16.gif");
    private final ImageIcon largeIcon = loadIcon("/toolbarButtonGraphics/general/Open24.gif");

    private final JFileChooser fileChooser = new RaceFileChooser();
    private final Collection<LoadRaceListener> listeners = new ArrayList<>();

    private JFrame window;

    public ShowOpenFileDialogAction() {
        setLargeIcon(largeIcon);
        setSmallIcon(smallIcon);
        setText("Open");
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }

    public void addLoadRaceListener(LoadRaceListener listener) {
        listeners.add(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int result = fileChooser.showOpenDialog(window);
        if (result == APPROVE_OPTION) {
            try {
                Track track = new DefaultTrack();
                RaceDataLoader loader = new RaceDataLoader(track);
                RaceData raceData = loader.loadRaceData(fileChooser.getSelectedFile());
                fireRaceLoaded(raceData);
            } catch (RaceException ex) {
                JOptionPane.showMessageDialog(window, ex.getMessage(), ERROR_MESSAGE_TITLE, ERROR_MESSAGE);
            }
        }
    }

    public void fireRaceLoaded(RaceData raceData) {
        listeners.forEach(l -> l.raceLoaded(raceData));
    }

}
