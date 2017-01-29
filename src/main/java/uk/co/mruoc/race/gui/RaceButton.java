package uk.co.mruoc.race.gui;

import javax.swing.*;

public class RaceButton extends JButton {

    public RaceButton(RaceAction action) {
        super();
        setAction(action);
        setToolTipText(action.getText());
        setText("");
    }

}
