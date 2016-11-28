package uk.co.mruoc.race;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTimeConverter;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class FileLoaderTest {

    private final File file = new File("data/raceinfo.dat");

    private final FileLoader loader = new FileLoader();
    private final ElapsedTimeConverter converter = new ElapsedTimeConverter();

    @Test
    public void shouldLoadEveryLineOfFile() {
        CarData carData = loader.load(file);

        assertThat(carData.getLineCount()).isEqualTo(1147);
    }

    @Test
    public void shouldGroupLinesByCar() {
        CarData carData = loader.load(file);

        assertThat(carData.getLineCountForCar(0)).isEqualTo(163);
        assertThat(carData.getLineCountForCar(1)).isEqualTo(163);
        assertThat(carData.getLineCountForCar(2)).isEqualTo(6);
        assertThat(carData.getLineCountForCar(3)).isEqualTo(163);
        assertThat(carData.getLineCountForCar(4)).isEqualTo(163);
        assertThat(carData.getLineCountForCar(5)).isEqualTo(163);
        assertThat(carData.getLineCountForCar(6)).isEqualTo(163);
        assertThat(carData.getLineCountForCar(7)).isEqualTo(163);
    }

}
