package uk.co.mruoc.race;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTimeConverter;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DataLoaderTest {

    private final File file = new File("data/raceinfo.dat");

    private final DataLoader loader = new DataLoader();
    private final ElapsedTimeConverter converter = new ElapsedTimeConverter();

    @Test
    public void shouldLoadEveryLineOfFile() {
        List<DataLine> lines = loader.load(file);

        assertThat(lines.size()).isEqualTo(1147);
    }

    @Test
    public void firstLineShouldBeLoadedCorrectly() {
        List<DataLine> lines = loader.load(file);

        DataLine line = lines.get(0);
        assertThat(converter.toString(line.getTime())).isEqualTo("00:00:00.000");
        assertThat(line.getCarId()).isEqualTo(5);
        assertThat(line.getCheckpointId()).isEqualTo(0);
        assertThat(line.isQueried()).isFalse();
    }

    @Test //TODO this needs fixing once 1.0.3 elapsed time is used, it should be .850 not .085
    public void lastLineShouldBeLoadedCorrectly() {
        List<DataLine> lines = loader.load(file);

        DataLine line = lines.get(1146);
        assertThat(converter.toString(line.getTime())).isEqualTo("00:50:48.085");
        assertThat(line.getCarId()).isEqualTo(6);
        assertThat(line.getCheckpointId()).isEqualTo(0);
        assertThat(line.isQueried()).isFalse();
    }

}
