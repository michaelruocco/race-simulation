package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.ClasspathFileLoader;

import javax.swing.*;
import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import java.awt.*;

public class AboutPopupWindow extends PopupWindow {

    public AboutPopupWindow() {
        super(false);
        setTitle("About");
        setPreferredSize(new Dimension(400, 315));
        add(new JScrollPane(new AboutPane()));
        pack();
    }

    private static class AboutPane extends JEditorPane {

        private static final String CONTENT_FILE_PATH = "/uk/co/mruoc/race/gui/html/about.html";

        private final ClasspathFileLoader fileLoader = new ClasspathFileLoader();

        public AboutPane() {
            setEditable(false);
            setContentType("text/html");
            setEditorKit(buildEditorKit());
            setText(fileLoader.loadContent(CONTENT_FILE_PATH));
        }

        private EditorKit buildEditorKit() {
            HTMLEditorKit editorKit = new HTMLEditorKit();
            StyleSheet styleSheet = editorKit.getStyleSheet();
            styleSheet.addRule("body { font-family:Arial; font-size:small; }");
            return editorKit;
        }

    }

}
