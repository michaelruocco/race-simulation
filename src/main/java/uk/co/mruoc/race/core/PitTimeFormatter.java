package uk.co.mruoc.race.core;

public class PitTimeFormatter implements CarStatFormatter {

    @Override
    public String format(CarStats stats) {
        if (stats.hasPitted())
            return stats.getPitTime().toString();
        return NOT_APPLICABLE;
    }

}
