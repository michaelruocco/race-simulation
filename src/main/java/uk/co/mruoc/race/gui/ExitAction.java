package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import static java.awt.event.WindowEvent.WINDOW_CLOSING;

public class ExitAction extends RaceAction {

    private JFrame window;

    public ExitAction() {
        setSmallIcon(EmptyIcon.getSmall());
        setLargeIcon(EmptyIcon.getLarge());
        setText("Exit");
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.dispatchEvent(new WindowEvent(window, WINDOW_CLOSING));
    }

}
