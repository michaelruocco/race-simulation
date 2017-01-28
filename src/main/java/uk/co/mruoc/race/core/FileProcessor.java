package uk.co.mruoc.race.core;

import org.apache.commons.io.FileUtils;
import uk.co.mruoc.race.core.RaceData.RaceDataBuilder;
import uk.co.mruoc.time.ElapsedTime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
        List<Line> inputs = readLines(file);
        List<FileLine> lines = parser.parse(inputs);
        List<ElapsedTime> queryTimes = queryTimeConverter.toQueryTimes(lines);
        Map<Integer, List<FileLine>> carLines = fileLineGrouper.groupByCarId(lines);
        List<CarData> carData = carDataConverter.toCarData(carLines);
        return new RaceDataBuilder()
                .setQueryTimes(queryTimes)
                .setCarDataList(carData)
                .build();
    }

    private List<Line> readLines(File file) {
        try {
            List<String> inputs = FileUtils.readLines(file, ENCODING);
            List<Line> lines = new ArrayList<>();
            for (int i = 0; i < inputs.size(); i++)
                lines.add(new Line(i, inputs.get(i)));
            return lines;
        } catch (FileNotFoundException e) {
            throw new FileProcessingException(buildFileNotFoundMessage(file), e);
        } catch (IOException e) {
            throw new FileProcessingException(buildGeneralErrorMessage(file), e);
        }
    }

    private String buildFileNotFoundMessage(File file) {
        return "file " + file.getAbsolutePath() + " does not exist";
    }

    private String buildGeneralErrorMessage(File file) {
        return "unable to process file " + file.getAbsolutePath();
    }

}
