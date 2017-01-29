package uk.co.mruoc.race.core;

public class IdFormatter implements CarStatFormatter {

    @Override
    public String format(CarStats stats) {
        return Integer.toString(stats.getCarId());
    }

}
