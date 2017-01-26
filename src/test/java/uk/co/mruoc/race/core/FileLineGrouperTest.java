package uk.co.mruoc.race.core;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class FileLineGrouperTest {

    private static final int CAR_ID_1 = 1;
    private static final int CAR_ID_2 = 2;

    private final TestFileLineBuilder builder = new TestFileLineBuilder();
    private final FileLine line1 = builder.setCarId(CAR_ID_1).build();
    private final FileLine line2 = builder.setCarId(CAR_ID_2).build();
    private final FileLine line3 = builder.setCarId(CAR_ID_1).build();
    private final FileLine line4 = builder.setCarId(CAR_ID_1).build();
    private final List<FileLine> lines = Arrays.asList(line1, line2, line3, line4);

    private final FileLineGrouper grouper = new FileLineGrouper();

    @Test
    public void shouldGroupLinesByCarId1() {
        Map<Integer, List<FileLine>> carLines = grouper.groupByCarId(lines);

        assertThat(carLines.get(CAR_ID_1).size()).isEqualTo(3);
        assertThat(carLines.get(CAR_ID_1)).containsExactly(line1, line3, line4);
    }

    @Test
    public void shouldGroupLinesByCarId2() {
        Map<Integer, List<FileLine>> carLines = grouper.groupByCarId(lines);

        assertThat(carLines.get(CAR_ID_2).size()).isEqualTo(1);
        assertThat(carLines.get(CAR_ID_2)).containsExactly(line2);
    }

}
