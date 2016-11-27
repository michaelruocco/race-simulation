package uk.co.mruoc.race;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;

import static org.assertj.core.api.Assertions.assertThat;

public class DataLineParserTest {

    private static final String INPUT = "00:16:05.67 7 3 0";
    private static final String QUERIED_INPUT = "00:12:46.05 3 3 1";
    private static final String RETIRED_INPUT = "00:01:53.55 2 R 0";

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
        DataLine line = parser.parse(INPUT);
        DataLine retiredLine = parser.parse(RETIRED_INPUT);

        assertThat(line.getCheckpointId()).isEqualTo('3');
        assertThat(retiredLine.getCheckpointId()).isEqualTo('R');
    }

    @Test
    public void shouldParseQueriedFlag() {
        DataLine line = parser.parse(INPUT);
        DataLine queriedLine = parser.parse(QUERIED_INPUT);

        assertThat(line.isQueried()).isFalse();
        assertThat(queriedLine.isQueried()).isTrue();
    }

}
