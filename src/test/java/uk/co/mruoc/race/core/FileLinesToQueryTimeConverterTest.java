package uk.co.mruoc.race.core;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileLinesToQueryTimeConverterTest {

    private final TestFileLineBuilder builder = new TestFileLineBuilder();
    private final FileLinesToQueryTimeConverter converter = new FileLinesToQueryTimeConverter();

    @Test
    public void shouldReturnTimesFromQueriedLines() {
        ElapsedTime queryTime1 = new ElapsedTime("00:00:10.000");
        ElapsedTime queryTime2 = new ElapsedTime("00:00:30.000");

        List<FileLine> lines = new ArrayList<>();
        lines.add(builder.setTime(new ElapsedTime("00:00:00.000")).setQueried(false).build());
        lines.add(builder.setTime(queryTime1).setQueried(true).build());
        lines.add(builder.setTime(new ElapsedTime("00:00:20.000")).setQueried(false).build());
        lines.add(builder.setTime(queryTime2).setQueried(true).build());

        List<ElapsedTime> queriedTimes = converter.toQueryTimes(lines);

        assertThat(queriedTimes.size()).isEqualTo(2);
        assertThat(queriedTimes.get(0)).isEqualTo(queryTime1);
        assertThat(queriedTimes.get(1)).isEqualTo(queryTime2);
    }

}
