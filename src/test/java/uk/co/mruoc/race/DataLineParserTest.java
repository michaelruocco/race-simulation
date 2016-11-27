package uk.co.mruoc.race;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;
import static org.assertj.core.api.Assertions.assertThat;

public class DataLineParserTest {

    private static final String INPUT = "00:16:05.67 7 3 0";

    private final DataLineParser parser = new DataLineParser();

    @Test
    public void shouldParseTime() {
        DataLine line = parser.parse(INPUT);

        ElapsedTime time = line.getTime();
        assertThat(time.getHours()).isEqualTo(0);
        assertThat(time.getMinutes()).isEqualTo(16);
        assertThat(time.getSeconds()).isEqualTo(5);
        assertThat(time.getMillis()).isEqualTo(67);
    }

    @Test
    public void shouldParseCarId() {
        DataLine line = parser.parse(INPUT);

        assertThat(line.getCarId()).isEqualTo(7);
    }

    @Test
    public void shouldParseCheckpointId() {
        String retiredInput = "00:01:53.55 2 R 0";
        DataLine line = parser.parse(INPUT);
        DataLine retiredLine = parser.parse(retiredInput);

        assertThat(line.getCheckpointId()).isEqualTo(3);
        assertThat(retiredLine.getCheckpointId()).isEqualTo(-1);
    }

    @Test
    public void shouldParseQueriedFlag() {
        String queriedInput = "00:12:46.05 3 3 1";
        DataLine line = parser.parse(INPUT);
        DataLine queriedLine = parser.parse(queriedInput);

        assertThat(line.isQueried()).isFalse();
        assertThat(queriedLine.isQueried()).isTrue();
    }

}
