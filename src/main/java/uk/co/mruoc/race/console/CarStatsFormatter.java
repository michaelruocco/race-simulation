package uk.co.mruoc.race.console;

import uk.co.mruoc.race.model.CarStats;
import uk.co.mruoc.race.model.PitStats;
import uk.co.mruoc.race.model.SpeedConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CarStatsFormatter {

    private final SpeedConverter speedConverter = new SpeedConverter();

    public List<String> format(CarStats carStats) {
        List<String> values = new ArrayList<>();
        values.add(formatPosition(carStats));
        values.add(formatCarId(carStats));
        values.add(formatSpeed(carStats));
        values.add(formatLapNumber(carStats));
        values.add(formatTimeDifference(carStats));
        values.add(formatAverageLapSpeed(carStats));
        values.add(formaxMaximumAverageLapSpeed(carStats));
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

    private String formaxMaximumAverageLapSpeed(CarStats stats) {
        return formatSpeed(stats.getMaximumAverageLapSpeed());
    }

    private String formatLapNumber(CarStats stats) {
        return Integer.toString(stats.getLapNumber());
    }

    private String formatTimeDifference(CarStats stats) {
        if (stats.getPosition() == 1)
            return "Leader";
        return stats.getTimeDifference().toString();
    }

    private String formatPitTime(PitStats stats) {
        if (stats.hasPitted())
            return stats.getTime().toString();
        return "-";
    }

    private String formatPitLapNumber(PitStats stats) {
        if (stats.hasPitted())
            return Integer.toString(stats.getLapNumber());
        return "-";
    }

    private String formatSpeed(BigDecimal speed) {
        return speedConverter.metersPerMilliToKmPerHour(speed).setScale(2, RoundingMode.HALF_UP).toString();
    }

}
