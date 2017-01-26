package uk.co.mruoc.race.core;

public class LapNumberFormatter implements CarStatFormatter {

    @Override
    public String format(CarStats stats) {
        return Integer.toString(stats.getLapNumber());
    }

}
