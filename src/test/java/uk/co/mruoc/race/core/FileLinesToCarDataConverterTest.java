package uk.co.mruoc.race.core;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class FileLinesToCarDataConverterTest {

    private final TestFileLineBuilder builder = new TestFileLineBuilder();
    private final DistanceProvider distanceProvider = new DefaultDistanceProvider();
    private final FakePitProvider pitProvider = new FakePitProvider();
    private final FileLinesToSplitsConverter splitsConverter = new FileLinesToSplitsConverter(distanceProvider, pitProvider);

    private final FileLinesToCarDataConverter converter = new FileLinesToCarDataConverter(splitsConverter);

    @Test
    public void shouldConvertToCarData() {
        Map<Integer, List<FileLine>> lines = new HashMap<>();
        lines.put(1, buildCarFileLines(1));
        lines.put(2, buildCarFileLines(2));

        List<CarData> carDataList = converter.toCarData(lines);

        assertThat(carDataList.size()).isEqualTo(2);
        assertThat(carDataList.get(0).getCarId()).isEqualTo(1);
        assertThat(carDataList.get(1).getCarId()).isEqualTo(2);
    }

    private List<FileLine> buildCarFileLines(int carId) {
        List<FileLine> lines = new ArrayList<>();
        lines.add(builder.setCarId(carId).setCheckpointId(0).build());
        lines.add(builder.setCarId(carId).setCheckpointId(1).build());
        lines.add(builder.setCarId(carId).setCheckpointId(2).build());
        lines.add(builder.setCarId(carId).setCheckpointId(0).build());
        return lines;
    }

}
