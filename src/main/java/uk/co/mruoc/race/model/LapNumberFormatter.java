package uk.co.mruoc.race.model;

public class LapNumberFormatter implements CarStatFormatter {

    @Override
    public String format(CarStats stats) {
        return Integer.toString(stats.getLapNumber());
    }

}
