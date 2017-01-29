package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import java.util.Iterator;

import static javax.swing.BorderFactory.createEtchedBorder;
import static javax.swing.border.EtchedBorder.LOWERED;

public class StatusPane extends JEditorPane {

    private final HtmlBuilder builder = new HtmlBuilder();
    private final CarStatsToIdsConverter converter = new CarStatsToIdsConverter();

    public StatusPane() {
        setEditable(false);
        setContentType("text/html");
        setBorder(createEtchedBorder(LOWERED));
    }

    public void setCssRules(CssRules cssRules) {
        setEditorKit(buildEditorKit(cssRules));
    }

    public void updateStatus(Iterator<CarStats> carStats) {
        try {
            Document document = getDocument();
            document.remove(0, document.getLength());
            setText(builder.build(carStats));
        } catch (BadLocationException e) {
            throw new RuntimeException(e);
        }
    }

    private EditorKit buildEditorKit(CssRules cssRules) {
        HTMLEditorKit editorKit = new HTMLEditorKit();
        StyleSheet styleSheet = editorKit.getStyleSheet();
        cssRules.forEach(styleSheet::addRule);
        return editorKit;
    }

}
