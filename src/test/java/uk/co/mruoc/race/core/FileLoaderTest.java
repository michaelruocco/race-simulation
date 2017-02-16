package uk.co.mruoc.race.core;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

public class FileLoaderTest {

    private static final String NEW_LINE = System.lineSeparator();

    private final FileLoader fileLoader = new FileLoader();

    @Test
    public void shouldReturnFileContent() {
        String content = fileLoader.loadContent("/uk/co/mruoc/race/core/test.txt");

        assertThat(content).isEqualTo("some test text" + NEW_LINE +
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
