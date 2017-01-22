package uk.co.mruoc.race.model;

import org.apache.commons.io.FileUtils;
import uk.co.mruoc.time.ElapsedTime;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.Map;

public class FileProcessor {

    private static final String ENCODING = "utf-8";

    private final FileLineParser parser = new FileLineParser();
    private final FileLineGrouper fileLineGrouper = new FileLineGrouper();
    private final FileLinesToQueryTimeConverter queryTimeConverter = new FileLinesToQueryTimeConverter();
    private final FileLinesToCarDataConverter carDataConverter;

    public FileProcessor(FileLinesToCarDataConverter carDataConverter) {
        this.carDataConverter = carDataConverter;
    }

    public RaceData process(File file) {
        try {
            List<String> inputs = FileUtils.readLines(file, ENCODING);
            List<FileLine> lines = parser.parse(inputs);
            List<ElapsedTime> queryTimes = queryTimeConverter.toQueryTimes(lines);
            Map<Integer, List<FileLine>> carLines = fileLineGrouper.groupByCarId(lines);
            List<CarData> carData = carDataConverter.toCarData(carLines);
            return new RaceData.RaceDataBuilder()
                    .setQueryTimes(queryTimes)
                    .setCarDataList(carData)
                    .build();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
