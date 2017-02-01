package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;

import java.util.Iterator;

public interface HtmlBuilder {

    String build(Iterator<CarStats> carStats);

}
