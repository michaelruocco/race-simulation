package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.RaceData;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import java.util.Iterator;

import static javax.swing.BorderFactory.createEtchedBorder;
import static javax.swing.border.EtchedBorder.LOWERED;

public class StatusPane extends JEditorPane implements RaceUpdateListener, LoadRaceListener {

    private final CarStatsToCssRulesConverter carStatsToCssRulesConverter = new CarStatsToCssRulesConverter();
    private final HtmlBuilder builder = new HtmlBuilder();

    public StatusPane(RaceData raceData) {
        this();
        raceLoaded(raceData);
    }

    public StatusPane() {
        setEditable(false);
        setContentType("text/html");
        setBorder(createEtchedBorder(LOWERED));
    }

    @Override
    public void raceUpdated(RaceData raceData) {
        updateStatus(raceData.getAllCarStats());
    }

    @Override
    public void raceLoaded(RaceData raceData) {
        CssRules cssRules = carStatsToCssRulesConverter.toCssRules(raceData.getAllCarStats());
        setCssRules(cssRules);
        raceUpdated(raceData);
    }

    private void setCssRules(CssRules cssRules) {
        setEditorKit(buildEditorKit(cssRules));
    }

    private void updateStatus(Iterator<CarStats> carStats) {
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
