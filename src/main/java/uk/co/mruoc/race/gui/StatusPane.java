package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;
import uk.co.mruoc.race.core.RaceData;
import uk.co.mruoc.race.core.RaceException;

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
    private final HtmlBuilder htmlBuilder;

    public StatusPane(HtmlBuilder htmlBuilder, RaceData raceData) {
        this(htmlBuilder);
        raceLoaded(raceData);
    }

    public StatusPane(HtmlBuilder htmlBuilder) {
        setEditable(false);
        setContentType("text/html");
        setBorder(createEtchedBorder(LOWERED));
        this.htmlBuilder = htmlBuilder;
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
            setText(htmlBuilder.build(carStats));
        } catch (BadLocationException e) {
            throw new RaceException(e);
        }
    }

    private EditorKit buildEditorKit(CssRules cssRules) {
        HTMLEditorKit editorKit = new HTMLEditorKit();
        StyleSheet styleSheet = editorKit.getStyleSheet();
        cssRules.forEach(styleSheet::addRule);
        return editorKit;
    }

}
