package uk.co.mruoc.race;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTimeConverter;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileLoaderTest {

    private final File file = new File("data/raceinfo.dat");

    private final FileLoader loader = new FileLoader();
    private final ElapsedTimeConverter converter = new ElapsedTimeConverter();

    @Test
    public void shouldLoadEveryLineOfFile() {
        List<FileLine> lines = loader.load(file);

        assertThat(lines.size()).isEqualTo(1147);
    }

    @Test
    public void firstLineShouldBeLoadedCorrectly() {
        List<FileLine> lines = loader.load(file);

        FileLine line = lines.get(0);
        assertThat(converter.toString(line.getTime())).isEqualTo("00:00:00.000");
        assertThat(line.getCarId()).isEqualTo(5);
        assertThat(line.getCheckpointId()).isEqualTo(0);
        assertThat(line.isQueried()).isFalse();
    }

    @Test
    public void lastLineShouldBeLoadedCorrectly() {
        List<FileLine> lines = loader.load(file);

        FileLine line = lines.get(1146);
        assertThat(converter.toString(line.getTime())).isEqualTo("00:50:48.850");
        assertThat(line.getCarId()).isEqualTo(6);
        assertThat(line.getCheckpointId()).isEqualTo(0);
        assertThat(line.isQueried()).isFalse();
    }

}
