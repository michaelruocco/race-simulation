package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import static java.awt.event.WindowEvent.WINDOW_CLOSING;

public class ExitAction extends RaceAction {

    private final JFrame window;

    public ExitAction(JFrame window) {
        this.window = window;
        setSmallIcon(EmptyIcon.getSmall());
        setLargeIcon(EmptyIcon.getLarge());
        setText("Exit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.dispatchEvent(new WindowEvent(window, WINDOW_CLOSING));
    }

}
