package uk.co.mruoc.race.core;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FileLoaderTest {

    private final FileLoader fileLoader = new FileLoader();

    @Test
    public void shouldReturnFileContent() {
        String content = fileLoader.loadContent("/uk/co/mruoc/race/core/test.txt");

        assertThat(content).isEqualTo("some test text");
    }

}
