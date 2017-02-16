package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.*;

public class ShowTrackPanelWindowAction extends ShowPopupWindowAction {

    private final ImageIcon smallIcon = EmptyIcon.getSmall();
    private final ImageIcon largeIcon = EmptyIcon.getLarge();

    private final JInternalFrame window;
    private final JPanel panel;

    public ShowTrackPanelWindowAction(String text, JInternalFrame window, JPanel panel) {
        super(window);
        setSmallIcon(smallIcon);
        setLargeIcon(largeIcon);
        setText(text);

        this.window = window;
        this.panel = panel;
    }

    @Override
    public void showWindow() {
        showPanelInWindow();
        super.showWindow();
    }

    private void showPanelInWindow() {
        Container container = window.getContentPane();
        container.removeAll();
        container.add(panel);
        window.pack();
    }

}
