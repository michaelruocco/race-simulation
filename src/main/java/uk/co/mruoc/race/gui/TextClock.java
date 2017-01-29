package uk.co.mruoc.race.gui;

import uk.co.mruoc.time.ElapsedTime;
import uk.co.mruoc.time.ElapsedTimeFormatter;

import javax.swing.*;

public class TextClock extends JLabel {

    private static final ElapsedTimeFormatter TIME_FORMATTER = new ElapsedTimeFormatter();

    public TextClock()  {
        super("", CENTER);
    }

    public void update(ElapsedTime time) {
        setText(format(time));
        repaint();
    }

    private static String format(ElapsedTime time) {
        return TIME_FORMATTER.format(time);
    }

}
