package uk.co.mruoc.race.core;

import uk.co.mruoc.race.core.RaceData.RaceDataBuilder;
import uk.co.mruoc.time.ElapsedTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileProcessor {

    private final FileLoader fileLoader = new FileLoader();
    private final FileLineParser parser = new FileLineParser();
    private final FileLineGrouper fileLineGrouper = new FileLineGrouper();
    private final FileLinesToQueryTimeConverter queryTimeConverter = new FileLinesToQueryTimeConverter();
    private final FileLinesToCarDataConverter carDataConverter;

    public FileProcessor(FileLinesToCarDataConverter carDataConverter) {
        this.carDataConverter = carDataConverter;
    }

    public RaceData process(String path) {
        List<String> inputs = fileLoader.loadLines(path);
        return processLines(inputs);
    }

    private RaceData processLines(List<String> inputs) {
        List<FileLine> lines = toLines(inputs);
        List<ElapsedTime> queryTimes = queryTimeConverter.toQueryTimes(lines);
        Map<Integer, List<FileLine>> carLines = fileLineGrouper.groupByCarId(lines);
        List<CarData> carData = carDataConverter.toCarData(carLines);
        return new RaceDataBuilder()
                .setQueryTimes(queryTimes)
                .setCarDataList(carData)
                .build();
    }

    private List<FileLine> toLines(List<String> inputs) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < inputs.size(); i++)
            lines.add(new Line(i, inputs.get(i)));
        return parser.parse(lines);
    }

}
