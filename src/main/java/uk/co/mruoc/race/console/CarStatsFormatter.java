package uk.co.mruoc.race.console;

import uk.co.mruoc.race.model.CarStats;
import uk.co.mruoc.race.model.PitStats;
import uk.co.mruoc.race.model.SpeedConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static java.math.RoundingMode.*;

public class CarStatsFormatter {

    private static final String NOT_APPLICABLE = "-";
    private final SpeedConverter speedConverter = new SpeedConverter();

    public List<String> format(CarStats stats) {
        List<String> values = new ArrayList<>();
        values.add(formatPosition(stats));
        values.add(formatCarId(stats));
        values.add(formatSpeed(stats));
        values.add(formatLapNumber(stats));
        values.add(formatTimeDifference(stats));
        values.add(formatAverageLapSpeed(stats));
        values.add(formaxMaximumAverageLapSpeed(stats));
        values.add(formatPitTime(stats));
        values.add(formatPitLapNumber(stats));
        values.add(formatRetiredTime(stats));
        values.add(formatRetiredLap(stats));
        values.add(formatRetiredDistance(stats));
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
        if (stats.getLapNumber() <= 1)
            return NOT_APPLICABLE;
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

    private String formatPitTime(CarStats stats) {
        if (stats.hasPitted())
            return stats.getPitTime().toString();
        return NOT_APPLICABLE;
    }

    private String formatPitLapNumber(CarStats stats) {
        if (stats.hasPitted())
            return Integer.toString(stats.getPitLapNumber());
        return NOT_APPLICABLE;
    }

    private String formatRetiredTime(CarStats stats) {
        if (stats.hasRetired())
            return stats.getRetiredTime().toString();
        return NOT_APPLICABLE;
    }

    private String formatRetiredLap(CarStats stats) {
        if (stats.hasRetired())
            return formatLapNumber(stats);
        return NOT_APPLICABLE;
    }

    private String formatRetiredDistance(CarStats stats) {
        if (stats.hasRetired())
            return formatDistance(stats);
        return NOT_APPLICABLE;
    }

    private String formatSpeed(BigDecimal speed) {
        return format(speedConverter.metersPerMilliToKmPerHour(speed));
    }

    private String formatDistance(CarStats stats) {
        return format(stats.getDistance());
    }

    private String format(BigDecimal value) {
        if (value == null)
            value = BigDecimal.ZERO;
        return value.setScale(2, HALF_UP).toString();
    }

}
