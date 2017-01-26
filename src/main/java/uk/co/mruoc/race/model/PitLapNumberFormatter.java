package uk.co.mruoc.race.model;

public class PitLapNumberFormatter implements CarStatFormatter {

    @Override
    public String format(CarStats stats) {
        if (stats.hasPitted())
            return Integer.toString(stats.getPitLapNumber());
        return NOT_APPLICABLE;
    }

}
