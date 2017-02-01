package uk.co.mruoc.race.gui;

import javax.swing.*;
import java.awt.*;

public class AboutPopupWindow extends PopupWindow {

    public AboutPopupWindow() {
        super(new AboutPane(), false);
        setTitle("About");
        setPreferredSize(new Dimension(400, 330));
        pack();
    }

    private static class AboutPane extends JEditorPane {

        private static final String TEXT = "<p>This race simulation program has been produced by Michael Ruocco.</p>" +
                "<p>It is a rework of a solution to a computer programming project that was done as part of the CS223 - " +
                "Introduction to Software Engineering module in the second year of the computer science degree at " +
                "the University of Warwick.</p>" +
                "<p>The original attempt was created by group \"Tau 4 Now\" which included the following members:</p>" +
                "<ul><li>Michael Ruocco</li><li>Edward Steel</li><li>James Gough</li><li>Christopher Dean</li>" +
                "<li>Philip Ananin</li><li>Mark Flintstone</li></ul>";

        public AboutPane() {
            setEditable(false);
            setContentType("text/html");
            setText(TEXT);
        }

    }

}
