package uk.co.mruoc.race.model;

public class RetiredTimeFormatter implements CarStatFormatter {

    @Override
    public String format(CarStats stats) {
        if (stats.hasRetired())
            return stats.getRetiredTime().toString();
        return NOT_APPLICABLE;
    }

}
