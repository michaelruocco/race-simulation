package uk.co.mruoc.race.model;

public class PositionFormatter implements CarStatFormatter {

    @Override
    public String format(CarStats stats) {
        return Integer.toString(stats.getPosition());
    }

}
