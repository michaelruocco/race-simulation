package uk.co.mruoc.race.gui;

import org.apache.commons.io.FilenameUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;

public class RaceFileChooser extends JFileChooser {

    public RaceFileChooser() {
        setFileFilter(new RaceFileFilter());
    }

    private static class RaceFileFilter extends FileFilter {

        @Override
        public boolean accept(File file) {
            return file.isDirectory() || isRaceDataFile(file);
        }

        private boolean isRaceDataFile(File file) {
            String extension = FilenameUtils.getExtension(file.getName());
            return "dat".equals(extension);
        }

        @Override
        public String getDescription() {
            return ".dat race data files";
        }

    }

}
