package uk.co.mruoc.race.core;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileLineParserTest {

    private static final Line DEFAULT_INPUT = toLine("00:16:05.67 7 3 0");

    private final FileLineParser parser = new FileLineParser();

    @Test
    public void shouldParseTime() {
        FileLine line = parser.parse(DEFAULT_INPUT);

        ElapsedTime time = line.getTime();
        assertThat(time.getHours()).isEqualTo(0);
        assertThat(time.getMinutes()).isEqualTo(16);
        assertThat(time.getSeconds()).isEqualTo(5);
        assertThat(time.getMillis()).isEqualTo(670);
    }

    @Test
    public void shouldParseCarId() {
        FileLine line = parser.parse(DEFAULT_INPUT);

        assertThat(line.getCarId()).isEqualTo(7);
    }

    @Test
    public void shouldParseCheckpointId() {
        Line retiredInput = toLine("00:01:53.55 2 R 0");
        FileLine line = parser.parse(DEFAULT_INPUT);
        FileLine retiredLine = parser.parse(retiredInput);

        assertThat(line.getCheckpointId()).isEqualTo(3);
        assertThat(retiredLine.getCheckpointId()).isEqualTo(-1);
    }

    @Test
    public void shouldParseQueriedFlag() {
        Line queriedInput = toLine("00:12:46.05 3 3 1");
        FileLine line = parser.parse(DEFAULT_INPUT);
        FileLine queriedLine = parser.parse(queriedInput);

        assertThat(line.isQueried()).isFalse();
        assertThat(queriedLine.isQueried()).isTrue();
    }

    @Test
    public void shouldParseMultipleLines() {
        Line secondInput = toLine("00:16:10.92 4 6 0");
        List<Line> inputs = Arrays.asList(DEFAULT_INPUT, secondInput);

        List<FileLine> lines = parser.parse(inputs);

        assertThat(lines.size()).isEqualTo(2);
    }

    private static Line toLine(String value) {
        return new Line(1, value);
    }

}
