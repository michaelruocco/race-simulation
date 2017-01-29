package uk.co.mruoc.race.core;

public class TimeDifferenceFormatter implements CarStatFormatter {

    @Override
    public String format(CarStats stats) {
        if (stats.getPosition() == 1)
            return "Leader";
        if (stats.hasRetired())
            return "Retired";
        return stats.getTimeDifference().toString();
    }

}
