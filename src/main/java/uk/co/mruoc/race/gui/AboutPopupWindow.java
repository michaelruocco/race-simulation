package uk.co.mruoc.race.gui;

import javax.swing.*;
import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import java.awt.*;

public class AboutPopupWindow extends PopupWindow {

    public AboutPopupWindow() {
        super(false);
        setTitle("About");
        setPreferredSize(new Dimension(400, 330));
        add(new JScrollPane(new AboutPane()));
        pack();
    }

    private static class AboutPane extends JEditorPane {

        private static final String TEXT = "<html><head></head><body><p>This race simulation program has been produced " +
                "by Michael Ruocco.</p><p>It is a rework of a solution to a computer programming project that was done" +
                "as part of the CS223 - Introduction to Software Engineering module in the second year of the computer " +
                "science degree at the University of Warwick.</p>" +
                "<p>The original attempt was created by group \"Tau 4 Now\" which included the following members:</p>" +
                "<ul><li>Michael Ruocco</li><li>Edward Steel</li><li>James Gough</li><li>Christopher Dean</li>" +
                "<li>Philip Ananin</li><li>Mark Flintstone</li></ul></body></html>";

        public AboutPane() {
            setEditable(false);
            setContentType("text/html");
            setEditorKit(buildEditorKit());
            setText(TEXT);
        }

        private EditorKit buildEditorKit() {
            HTMLEditorKit editorKit = new HTMLEditorKit();
            StyleSheet styleSheet = editorKit.getStyleSheet();
            styleSheet.addRule("body { font-family:Arial; font-size:small; }");
            return editorKit;
        }

    }

}
