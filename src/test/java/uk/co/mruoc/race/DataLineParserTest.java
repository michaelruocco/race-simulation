package uk.co.mruoc.race;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;

import static org.assertj.core.api.Assertions.assertThat;

public class DataLineParserTest {

    private static final String INPUT = "00:16:05.67 7 3 0";

    private final DataLineParser parser = new DataLineParser();

    @Test
    public void shouldParseTimeFromDataLine() {
        DataLine line = parser.parse(INPUT);

        ElapsedTime time = line.getTime();
        assertThat(time.getHours()).isEqualTo(0);
        assertThat(time.getMinutes()).isEqualTo(16);
        assertThat(time.getSeconds()).isEqualTo(5);
        assertThat(time.getMillis()).isEqualTo(67);
    }

}
