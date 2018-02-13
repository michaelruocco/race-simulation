package uk.co.mruoc.race.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

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
        Throwable thrown = catchThrowable(() -> fileLoader.loadContent("nonExistent"));

        assertThat(thrown).isInstanceOf(FileLoadException.class)
                .hasMessage("file nonExistent not found")
                .hasCauseInstanceOf(FileNotFoundException.class);
    }

    @Test
    public void loadLinesShouldThrowExceptionIfFileNotFound() {
        Throwable thrown = catchThrowable(() -> fileLoader.loadLines("nonExistent"));

        assertThat(thrown).isInstanceOf(FileLoadException.class)
                .hasMessage("file nonExistent not found")
                .hasCauseInstanceOf(FileNotFoundException.class);
    }

}
