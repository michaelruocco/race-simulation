package uk.co.mruoc.race.core;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTimeFormatException;

import java.io.FileNotFoundException;
import java.util.List;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

public class FileLoaderTest {

    private final FileLoader fileLoader = new FileLoader();

    @Test
    public void shouldReturnFileContent() {
        String content = fileLoader.loadContent("/uk/co/mruoc/race/core/test.txt");

        assertThat(content).isEqualTo("some test text\n" +
                "more text");
    }

    @Test
    public void shouldReturnFileLines() {
        List<String> lines = fileLoader.loadLines("/uk/co/mruoc/race/core/test.txt");

        assertThat(lines).containsExactly("some test text", "more text");
    }

    @Test
    public void loadContentShouldThrowExceptionIfFileNotFound() {
        when(fileLoader).loadContent("nonExistent");

        then(caughtException())
                .isInstanceOf(FileLoadException.class)
                .hasMessage("file nonExistent not found")
                .hasCauseInstanceOf(FileNotFoundException.class);
    }

    @Test
    public void loadLinesShouldThrowExceptionIfFileNotFound() {
        when(fileLoader).loadLines("nonExistent");

        then(caughtException())
                .isInstanceOf(FileLoadException.class)
                .hasMessage("file nonExistent not found")
                .hasCauseInstanceOf(FileNotFoundException.class);
    }

}
