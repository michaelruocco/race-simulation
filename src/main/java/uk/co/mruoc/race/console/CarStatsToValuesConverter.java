package uk.co.mruoc.race.console;

import uk.co.mruoc.race.model.CarStats;
import uk.co.mruoc.race.model.SpeedConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CarStatsToValuesConverter {

    private final SpeedConverter speedConverter = new SpeedConverter();

    public List<String> toValues(CarStats stats) {
        List<String> values = new ArrayList<>();
        values.add(formatPosition(stats));
        values.add(formatCarId(stats));
        values.add(formatSpeed(stats));
        values.add(formatLapNumber(stats));
        values.add(formatTimeDifference(stats));
        values.add(formatAverageLapSpeed(stats));
        values.add("");
        values.add("");
        values.add("");
        return values;
    }

    private String formatPosition(CarStats stats) {
        return Integer.toString(stats.getPosition());
    }

    private String formatCarId(CarStats stats) {
        return Integer.toString(stats.getCarId());
    }

    private String formatSpeed(CarStats stats) {
        return formatSpeed(stats.getSpeed());
    }

    private String formatAverageLapSpeed(CarStats stats) {
        return formatSpeed(stats.getAverageLapSpeed());
    }

    private String formatLapNumber(CarStats stats) {
        return Integer.toString(stats.getLapNumber());
    }

    private String formatTimeDifference(CarStats stats) {
        if (stats.getPosition() == 1)
            return "Leader";
        return stats.getTimeDifference().toString();
    }

    private String formatSpeed(BigDecimal speed) {
        return speedConverter.metersPerMilliToKmPerHour(speed).setScale(2, RoundingMode.HALF_UP).toString();
    }

}
