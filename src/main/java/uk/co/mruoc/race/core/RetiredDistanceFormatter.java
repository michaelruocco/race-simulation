package uk.co.mruoc.race.core;

public class RetiredDistanceFormatter implements CarStatFormatter {

    @Override
    public String format(CarStats stats) {
        if (stats.hasRetired())
            return format(stats.getDistance());
        return NOT_APPLICABLE;
    }

}
