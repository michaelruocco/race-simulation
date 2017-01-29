package uk.co.mruoc.race.gui;

import uk.co.mruoc.race.core.CarStats;

import java.util.Iterator;
import java.util.List;

public class CarStatsToCssRulesConverter {

    private final CarStatsToIdsConverter carStatsToIdsConverter = new CarStatsToIdsConverter();

    public CssRules toCssRules(Iterator<CarStats> carStats) {
        List<Integer> ids = carStatsToIdsConverter.toIds(carStats);
        return new CssRules(ids);
    }

}
