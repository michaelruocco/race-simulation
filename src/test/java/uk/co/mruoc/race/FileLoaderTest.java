package uk.co.mruoc.race;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTimeConverter;

import java.io.File;
import java.io.UncheckedIOException;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

public class FileLoaderTest {

    private final File file = new File("data/raceinfo.dat");

    private final FileLoader loader = new FileLoader();
    private final ElapsedTimeConverter converter = new ElapsedTimeConverter();

    @Test
    public void shouldLoadEveryLineOfFile() {
        CarsData carsData = loader.load(file);

        assertThat(carsData.getLineCount()).isEqualTo(1147);
    }

    @Test
    public void shouldGroupLinesByCar() {
        CarsData carsData = loader.load(file);

        assertThat(carsData.getLineCountForCar(0)).isEqualTo(163);
        assertThat(carsData.getLineCountForCar(1)).isEqualTo(163);
        assertThat(carsData.getLineCountForCar(2)).isEqualTo(6);
        assertThat(carsData.getLineCountForCar(3)).isEqualTo(163);
        assertThat(carsData.getLineCountForCar(4)).isEqualTo(163);
        assertThat(carsData.getLineCountForCar(5)).isEqualTo(163);
        assertThat(carsData.getLineCountForCar(6)).isEqualTo(163);
        assertThat(carsData.getLineCountForCar(7)).isEqualTo(163);
    }

    @Test
    public void shouldThrowErrorIfFileDoesNotExist() {
        when(loader).load(new File("nonExistent"));

        then(caughtException())
                .isInstanceOf(UncheckedIOException.class)
                .hasMessage("java.io.FileNotFoundException: File 'nonExistent' does not exist");
    }

}
