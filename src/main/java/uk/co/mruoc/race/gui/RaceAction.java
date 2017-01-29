package uk.co.mruoc.race.gui;

import javax.swing.*;

public abstract class RaceAction extends AbstractAction {

    public String getText() {
        return getValue(NAME).toString();
    }

    protected void setSmallIcon(ImageIcon icon) {
        putValue(SMALL_ICON, icon);
    }

    protected void setLargeIcon(ImageIcon icon) {
        putValue(LARGE_ICON_KEY, icon);
    }

    protected void setText(String text) {
        putValue(NAME, text);
    }

}
