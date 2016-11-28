package uk.co.mruoc.race;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class FileLineGrouperTest {

    private final FileLineGrouper grouper = new FileLineGrouper();

    @Test
    public void shouldGroupLinesByCarId() {
        List<FileLine> lines = createLinesWithCarIds(1, 3, 1, 2, 3, 1);

        Map<Integer, List<FileLine>> groupedLines = grouper.groupByCarId(lines);

        assertThat(groupedLines.get(1).size()).isEqualTo(3);
        assertThat(groupedLines.get(2).size()).isEqualTo(1);
        assertThat(groupedLines.get(3).size()).isEqualTo(2);
    }

    private List<FileLine> createLinesWithCarIds(int... carIds) {
        List<FileLine> lines = new ArrayList<>();
        for (int carId : carIds)
            lines.add(new TestFileLineBuilder().withCarId(carId).build());
        return lines;
    }

}
