package uk.co.mruoc.race.core;

public class TimeDifferenceFormatter implements CarStatFormatter {

    @Override
    public String format(CarStats stats) {
        if (stats.getPosition() == 1)
            return "Leader";
        return stats.getTimeDifference().toString();
    }

}
