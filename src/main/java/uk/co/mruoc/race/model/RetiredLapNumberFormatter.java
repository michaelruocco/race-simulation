package uk.co.mruoc.race.model;

public class RetiredLapNumberFormatter implements CarStatFormatter {

    private final LapNumberFormatter lapNumberFormatter = new LapNumberFormatter();

    @Override
    public String format(CarStats stats) {
        if (stats.hasRetired())
            return lapNumberFormatter.format(stats);
        return NOT_APPLICABLE;
    }

}
